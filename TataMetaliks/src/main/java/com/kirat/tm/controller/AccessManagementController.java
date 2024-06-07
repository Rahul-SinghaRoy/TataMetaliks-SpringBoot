package com.kirat.tm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.kirat.tm.constants.OLCProp;
import com.kirat.tm.model.JsonResponse;
import com.kirat.tm.model.RoleAccess;
import com.kirat.tm.model.RoleTransactionDetails;
import com.kirat.tm.model.ServiceResponse;
import com.kirat.tm.model.UserAccess;
import com.kirat.tm.utils.OLCUtil;

@Controller
@EnableWebMvc
public class AccessManagementController {

	public String accessURL = OLCUtil.getValue(OLCProp.URL_OF_ACCESSSERVICE);

//	String accessUrl ="http://14.141.110.54:8080/tmt-acsmngmnt/";
	// String accessUrl = "http://localhost:8080/tmt-acsmngmnt/";

	String accessUrl = "http://localhost:8083/";
//	String transUrl ="http://14.141.110.54:8080/tmt-modmngmnt/";
	// String transUrl = "http://localhost:8080/tmt-modmngmnt/";

	String transUrl = "http://localhost:8084/";

	private String roleAccessURL = accessURL + "/RoleAccess";

	private String userAccessURL = accessURL + "/UserAccess";

	// Method to create Role Access Details
	@RequestMapping(value = "/RoleAccess", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse createRoleAccess(@RequestBody RoleAccess roleAccess) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(roleAccessURL, roleAccess, ServiceResponse.class);
	}

	// Method to create Multiple Role Access Details once
	@RequestMapping(value = "/RoleAccessList", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse createRoleAccessList(@RequestBody List<RoleAccess> roleAccess) {
		for (int i = 0; i < roleAccess.size(); i++) {
			System.out.println(roleAccess.get(i).getModuleid().toString());
		}
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(roleAccessURL + "List", roleAccess, ServiceResponse.class);
	}

	// Method to get all Role Access Details
	@RequestMapping(value = "/RoleAccess", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getRoleAccessList() {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(roleAccessURL, ServiceResponse.class);

		return serviceResponse;
	}

	@RequestMapping(value = "/RoleAccessByRole/{role_id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getRoleAccessByRole(@PathVariable("role_id") String role_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(roleAccessURL + "ByRole/" + role_id,
				ServiceResponse.class);

		return serviceResponse;
	}

	// Method to create User Access Details
	@RequestMapping(value = "/UserAccess", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse createUserAccess(@RequestBody UserAccess userAccess) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(userAccessURL, userAccess, ServiceResponse.class);
	}

	@RequestMapping(value = "/UserAccess", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getUserAccessList() {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(userAccessURL, ServiceResponse.class);
		return serviceResponse;
	}

	@RequestMapping(value = "/UserAccessByRole/{role_id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getUserAccessByRole(@PathVariable("role_id") String role_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(userAccessURL + "ByRole/" + role_id,
				ServiceResponse.class);

		return serviceResponse;
	}

	@RequestMapping(value = "/UserAccessByAccountId/{accountid}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getUserAccessByAccount(@PathVariable("accountid") String accountid) {
		RestTemplate restTemplate = new RestTemplate();

		ServiceResponse serviceResponse = restTemplate.getForObject(userAccessURL + "ByAccountId/" + accountid,
				ServiceResponse.class);

		return serviceResponse;
	}

	@RequestMapping(value = "/UserAccessList", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse createUserAccessList(@RequestBody ModelMap model) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		String arrayname[] = model.get("roleid").toString().replace("[", "").split(",");
		for (int i = 0; i < arrayname.length; i++) {
			UserAccess userAccess = new UserAccess();
			userAccess.setRoleid(arrayname[i].toString().replace("]", "").replace(" ", ""));
			userAccess.setIdentifier(model.get("identifier").toString());
			userAccess.setAccountid(model.get("accountid").toString());
			serviceResponse = createUserAccess(userAccess);
		}

		return serviceResponse;
	}

	@RequestMapping(value = "/transactionAccess", method = RequestMethod.POST)
	public @ResponseBody JsonResponse createTransactionAccess(@RequestBody ModelMap model) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		JsonResponse response = new JsonResponse();
		ServiceResponse serviceResponse = new ServiceResponse();
		String arrayname[] = model.get("transaction_id").toString().replace("[", "").split(",");
		for (int i = 0; i < arrayname.length; i++) {
			RoleTransactionDetails role = new RoleTransactionDetails();
			role.setRole_id(model.get("role_id").toString());
			role.setModule_id(model.get("module_id").toString());
			role.setTransaction_id(arrayname[i].toString().replace("]", "").replace(" ", ""));
			serviceResponse = restTemplate.postForObject(accessUrl + "RoleTransaction", role, ServiceResponse.class);
		}
		response.setResult(serviceResponse);
		return response;
	}

	@RequestMapping(value = "/getRoleAccessDetails", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody JsonResponse getAllTransListByModuleId(@RequestBody ModelMap model)
			throws JsonParseException, JsonMappingException, IOException {

		JsonResponse response = new JsonResponse();
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse = restTemplate.getForObject(roleAccessURL + "ByRole/" + model.get("role_id").toString(),
				ServiceResponse.class);
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String actjson = ow.writeValueAsString(serviceResponse.getResponsedata());

		List<RoleAccess> roleaccessList = mapper.readValue(actjson,
				mapper.getTypeFactory().constructCollectionType(List.class, RoleAccess.class));

		ArrayList<HashMap<String, Object>> outer = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < roleaccessList.size(); i++) {
			HashMap<String, Object> inner = new HashMap<String, Object>();

			inner.put("role_id", model.get("role_id").toString());
			inner.put("module_id", roleaccessList.get(i).getModuleid().toString());
			serviceResponse = restTemplate.getForObject(
					transUrl + "transactionByModule/" + roleaccessList.get(i).getModuleid().toString(),
					ServiceResponse.class);
			inner.put("allTranslist", serviceResponse.getResponsedata());
			serviceResponse = restTemplate.getForObject(accessUrl + "RoleTransactionByRoleModule/"
					+ model.get("role_id").toString() + "/" + roleaccessList.get(i).getModuleid().toString(),
					ServiceResponse.class);
			inner.put("checkedTranslist", serviceResponse.getResponsedata());
			if (inner.size() > 0) {
				outer.add(inner);
			}
		}
		response.setResult(outer);
		return response;
	}

	@RequestMapping(value = "/updatetransactionAccess", method = RequestMethod.POST)
	public @ResponseBody JsonResponse updateTransactionAccess(@RequestBody ModelMap model) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		JsonResponse response = new JsonResponse();
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse = restTemplate.postForObject(accessUrl + "deleteRoleTransactionByRoleModule/", model,
				ServiceResponse.class);
		if (serviceResponse.getMessage().equals("RoleTransaction Deleted successfully")) {
			String arrayname[] = model.get("transaction_id").toString().replace("[", "").split(",");
			for (int i = 0; i < arrayname.length; i++) {
				RoleTransactionDetails role = new RoleTransactionDetails();
				role.setRole_id(model.get("role_id").toString());
				role.setModule_id(model.get("module_id").toString());
				role.setTransaction_id(arrayname[i].toString().replace("]", "").replace(" ", ""));
				serviceResponse = restTemplate.postForObject(accessUrl + "RoleTransaction", role,
						ServiceResponse.class);
			}
		}
		response.setResult(serviceResponse);
		return response;
	}

	@RequestMapping(value = "/updateUserAccess", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse createUserAccess(@RequestBody ModelMap reqmodel) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.postForObject(accessUrl + "UserAccessByAccountId", reqmodel,
				ServiceResponse.class);
		return serviceResponse;
	}

}
