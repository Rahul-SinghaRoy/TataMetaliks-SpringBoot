package com.kirat.tm.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
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
import com.kirat.tm.dto.TransactionListDto;
import com.kirat.tm.model.JsonResponse;
import com.kirat.tm.model.Role;
import com.kirat.tm.model.RoleAccess;
import com.kirat.tm.model.ServiceResponse;
import com.kirat.tm.utils.OLCUtil;

@Controller
@EnableWebMvc
public class RoleManagementController {
	public String roleURL = OLCUtil.getValue(OLCProp.URL_OF_ROLESERVICE);
	// String tataUrl="http://localhost:8080/TataMetaliks/";
	String tataUrl = "http://localhost:8080";

	@RequestMapping(value = "/Role", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse createRole(@RequestBody Role role) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(roleURL + "/Role", role, ServiceResponse.class);
	}

	@SuppressWarnings("unused")
	@RequestMapping(value = "/RolewithModule", method = RequestMethod.POST)
	public @ResponseBody JsonResponse createRolewithModule(@RequestBody ModelMap model) throws IOException {
		RestTemplate restTemplate = new RestTemplate();
		JsonResponse response = new JsonResponse();
		Role role = new Role();
		ModelMap resmodel = new ModelMap();
		role.setRolename(model.get("role_name").toString());
		ServiceResponse serviceResponse = restTemplate.postForObject(roleURL + "/Role", role, ServiceResponse.class);

		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String actjson = ow.writeValueAsString(serviceResponse.getResponsedata());
		Role resultrole = mapper.readValue(actjson, Role.class);
		if (serviceResponse.getMessage().equals("Role Created")) {

			RoleAccess roleAc = new RoleAccess();
			roleAc.setRoleid(resultrole.getRoleid().toString());
			roleAc.setModuleid(model.get("module_id").toString());

			serviceResponse = restTemplate.postForObject(tataUrl + "/RoleAccess", roleAc, ServiceResponse.class);
			if (serviceResponse.getMessage().equals("RoleAccess Created")) {
				TransactionListDto transactionslist = restTemplate.getForObject(
						tataUrl + "/transactionByModule/" + model.get("module_id").toString(),
						TransactionListDto.class);

				resmodel.addAttribute("translist", transactionslist.getResponsedata());
				resmodel.addAttribute("roleid", resultrole.getRoleid().toString());
				resmodel.addAttribute("module_id", model.get("module_id").toString());
				response.setResult(resmodel);

			}
		}

		return response;
	}

	@RequestMapping(value = "/Role", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getRoleList() {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(roleURL + "/Role", ServiceResponse.class);
		return serviceResponse;
	}

	@RequestMapping(value = "/Role/{role_id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getRoleById(@PathVariable("role_id") String role_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(roleURL + "/Role" + "/" + role_id,
				ServiceResponse.class);
		return serviceResponse;
	}

	@RequestMapping(value = "/Role", method = RequestMethod.PUT)
	public @ResponseBody ServiceResponse updateRole(@RequestBody Role role) {
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.put(roleURL + "/Role", role);
		ServiceResponse serviceResponse = restTemplate.getForObject(roleURL + "/Role" + "/" + role.getRoleid(),
				ServiceResponse.class);
		serviceResponse.setMessage("Role Updated");
		return serviceResponse;
	}

	@RequestMapping(value = "/Role/{role_id}", method = RequestMethod.DELETE)
	public @ResponseBody ServiceResponse deleteRole(@PathVariable("role_id") String role_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(roleURL + "/Role" + "/" + role_id,
				ServiceResponse.class);
		restTemplate.delete(roleURL + "/Role/" + role_id);
		serviceResponse.setMessage("Role Deleted");
		return serviceResponse;
	}
	
	@RequestMapping(value = "/roleList", method = RequestMethod.GET, consumes = "application/json")
	public @ResponseBody JsonResponse getAllRoleListTable()
			throws JsonParseException, JsonMappingException, IOException {

		JsonResponse response = new JsonResponse();
		RestTemplate restTemplate = new RestTemplate();

		ServiceResponse serviceResponse = restTemplate.getForObject(roleURL+"/Role", ServiceResponse.class);
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String actjson = ow.writeValueAsString(serviceResponse.getResponsedata());

		List<Role> roleList = mapper.readValue(actjson,
				mapper.getTypeFactory().constructCollectionType(List.class, Role.class));

		ArrayList<HashMap<String, Object>> outer = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < roleList.size(); i++) {
			HashMap<String, Object> inner = new HashMap<String, Object>();
			System.out.println(roleList.size());
			System.out.println(roleList.get(i));
			String actUpdate = "<button type = 'button' class='edit_btn' data-id ='" + roleList.get(i).getRoleid()
					+ "' tittle='Suspend'><em class='fa fa-edit'></em></button>";
			if (!roleList.get(i).getRolename().toLowerCase().equals("admin")) {
				inner.put("id", roleList.get(i).getRoleid().toString());
				inner.put("name", roleList.get(i).getRolename().toString());

				inner.put("status", "-");

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
