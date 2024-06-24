package com.kirat.tm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.kirat.tm.constants.OLCProp;
import com.kirat.tm.model.Account;
import com.kirat.tm.model.JsonResponse;
import com.kirat.tm.model.ResponsePojo;
import com.kirat.tm.model.ServiceResponse;
import com.kirat.tm.utils.OLCUtil;

@RestController
@EnableWebMvc
public class AccountManagementController {

	public String accountURL = OLCUtil.getValue(OLCProp.URL_OF_ACCOUNTSERVICE);

	String accessUrl = "http://14.141.110.54:8080/tmt-acsmngmnt/";
	String transUrl = "http://14.141.110.54:8080/tmt-modmngmnt/";
	String rolUrl = "http://14.141.110.54:8080/tmt-rolemngmnt/";

	@PostMapping(value = "/Account")
	public ServiceResponse createAccount(@RequestBody Account account) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.postForObject(accountURL + "/Account", account,
				ServiceResponse.class);
		return serviceResponse;
	}

	@GetMapping(value = "/Account")
	public JsonResponse getAccountList(@RequestBody ModelMap model) {
		JsonResponse response = new JsonResponse();
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(accountURL + "/Account", ServiceResponse.class);

		List<Account> accountlist = new ArrayList<Account>();
		List<Account> finalaccountlist = new ArrayList<Account>();
		accountlist = (List<Account>) serviceResponse.getResponsedata();
		for (Account a : accountlist) {
			if (!a.getId().equals(model.get("id"))) {
				finalaccountlist.add(a);
			}
		}
		response.setResult(accountlist);
		return response;
	}

	@GetMapping(value = "/AccountDtl/{account_id}")
	public JsonResponse getAccountD(@PathVariable("account_id") String account_id) {

		JsonResponse response = new JsonResponse();
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(accountURL + "/Account" + "/" + account_id,
				ServiceResponse.class);

		response.setResult(serviceResponse.getResponsedata());
		return response;
	}

	@PutMapping(value = "/Account")
	public ServiceResponse updateAccount(@RequestBody Account account) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			ResponsePojo serviceResponse1 = restTemplate.getForObject(accountURL + "/Account" + "/" + account.getId(),
					ResponsePojo.class);
			account.setTypeid(serviceResponse1.getResponsedata().getTypeid());
			account.setToken(serviceResponse1.getResponsedata().getToken());
			account.setCreatedate(serviceResponse1.getResponsedata().getCreatedate());
			account.setUpdatedate(serviceResponse1.getResponsedata().getUpdatedate());
			restTemplate.put(accountURL + "/Account", account);
			serviceResponse.setError(false);
			serviceResponse.setMessage("Account Updated");
		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to Fetch");
			serviceResponse.setResponsedata(account);
		}
		return serviceResponse;
	}

	@DeleteMapping(value = "/Account/{account_id}")
	public ServiceResponse deleteAccount(@PathVariable("account_id") String account_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.getForObject(accountURL + "/Account" + "/" + account_id,
					ServiceResponse.class);
			restTemplate.delete(accountURL + "/Account/" + account_id);
			serviceResponse.setError(false);
			serviceResponse.setMessage("Delete Successfull!");
		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to Fetch");
		}
		return serviceResponse;

	}

	// Method to Activate Account
	@PostMapping(value = "/AccountActivate")
	public ServiceResponse activateAccount(@RequestBody List<String> account_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.postForObject(accountURL + "/Account" + "Activate", account_id,
					ServiceResponse.class);

		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to Fetch");
		}
		return serviceResponse;

	}

	// Method to Deactivate Account
	@PostMapping(value = "/AccountDeactivate")
	public ServiceResponse deactivateAccount(@RequestBody List<String> account_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.postForObject(accountURL + "/Account" + "Deactivate", account_id,
					ServiceResponse.class);

		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to Fetch");
		}
		return serviceResponse;

	}

	@PostMapping(value = "/userList", consumes = "application/json")
	public JsonResponse getuserList(@RequestBody ModelMap reqmodel)
			throws JsonParseException, JsonMappingException, IOException {
		JsonResponse response = new JsonResponse();
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(accountURL + "/Account", ServiceResponse.class);
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String actjson = ow.writeValueAsString(serviceResponse.getResponsedata());
		List<Account> accountlist = mapper.readValue(actjson,
				mapper.getTypeFactory().constructCollectionType(List.class, Account.class));

		ArrayList<HashMap<String, Object>> outer = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < accountlist.size(); i++) {
			HashMap<String, Object> inner = new HashMap<String, Object>();
			System.out.println(accountlist.size());
			System.out.println(accountlist.get(i));
			String actUpdate = "<button type = 'button' class='edit_btn' data-id ='" + accountlist.get(i).getId()
					+ "' tittle='Suspend'><em class='fa fa-edit'></em></button>";

			if (!accountlist.get(i).getId().equals(reqmodel.get("id"))) {
				inner.put("id", accountlist.get(i).getId().toString());
				inner.put("name",
						accountlist.get(i).getFname().toString() + " " + accountlist.get(i).getLname().toString());
				if (accountlist.get(i).getIsActive() == 1) {
					inner.put("status", "Active");
				} else {
					inner.put("status", "InActive");
				}
				inner.put("action", actUpdate);
			}
			System.out.println(inner.size() > 0);
			if (inner.size() > 0) {
				outer.add(inner);
			}
		}
		response.setResult(outer);
		return response;
	}
}
