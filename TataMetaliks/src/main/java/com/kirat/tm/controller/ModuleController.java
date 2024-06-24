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
import com.kirat.tm.model.JsonResponse;
import com.kirat.tm.model.Module;
import com.kirat.tm.model.Report;
import com.kirat.tm.model.ServiceResponse;
import com.kirat.tm.model.Transactions;
import com.kirat.tm.utils.OLCUtil;

@RestController
@EnableWebMvc
public class ModuleController {

	public String moduleURL = OLCUtil.getValue(OLCProp.URL_OF_MODULESERVICE);

	// Method to create Module
	@PostMapping(value = "/module")
	public ServiceResponse createModule(@RequestBody Module module) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.postForObject(moduleURL + "/module", module,
				ServiceResponse.class);
		return serviceResponse;
	}

	// Method to get all modules
	@GetMapping(value = "/module")
	public ServiceResponse getModuleList() {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/module", ServiceResponse.class);
		return serviceResponse;
	}

	@GetMapping(value = "/moduleList", consumes = "application/json")
	public JsonResponse getAllmoduleList() throws JsonParseException, JsonMappingException, IOException {

		JsonResponse response = new JsonResponse();
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/module", ServiceResponse.class);
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String actjson = ow.writeValueAsString(serviceResponse.getResponsedata());

		List<Module> modulelist = mapper.readValue(actjson,
				mapper.getTypeFactory().constructCollectionType(List.class, Module.class));

		ArrayList<HashMap<String, Object>> outer = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < modulelist.size(); i++) {
			HashMap<String, Object> inner = new HashMap<String, Object>();
			System.out.println(modulelist.size());
			System.out.println(modulelist.get(i));
			String actUpdate = "<button type = 'button' class='edit_btn' data-id ='" + modulelist.get(i).getModule_id()
					+ "' tittle='Suspend'><em class='fa fa-edit'></em></button>";
			String actSuspend = "<input type='checkbox' className='js-Switch' name='act_btn'  data-id ='"
					+ modulelist.get(i).getModule_id() + "' checked />";
			String actResume = "<input type='checkbox' className='js-Switch' name='act_btn'  data-id ='"
					+ modulelist.get(i).getModule_id() + "' />";

			inner.put("id", modulelist.get(i).getModule_id().toString());
			inner.put("name", modulelist.get(i).getModule_name().toString());
			if (modulelist.get(i).getIsActive() == 1) {
				inner.put("status", "Active");
			} else {
				inner.put("status", "InActive");
			}
			inner.put("action", actUpdate);

			System.out.println(inner.size() > 0);
			if (inner.size() > 0) {
				outer.add(inner);
			}
		}
		response.setResult(outer);
		return response;
	}

	// Method to get module by id
	@GetMapping(value = "/module/{module_id}")
	public ServiceResponse getModuleById(@PathVariable("module_id") String module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/module" + "/" + module_id,
				ServiceResponse.class);
		return serviceResponse;

	}

	// Method to update module
	@PutMapping(value = "/module")
	public ServiceResponse updateModule(@RequestBody Module module) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			restTemplate.put(moduleURL + "/module", module);
			serviceResponse.setError(false);
			serviceResponse.setMessage("Module updated");
		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to fetch");
		}
		return serviceResponse;
	}

	// Method to delete module by id
	@DeleteMapping(value = "/module/{module_id}")
	public ServiceResponse deleteModule(@PathVariable("module_id") String module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.getForObject(moduleURL + "/module" + "/" + module_id, ServiceResponse.class);
			restTemplate.delete(moduleURL + "/module/" + module_id);
			serviceResponse.setError(false);
			serviceResponse.setMessage("Module Deleted");
		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Module does not exist");
		}
		return serviceResponse;
	}

	// Method to Activate Module
	@PostMapping(value = "/moduleActivate")
	public ServiceResponse activateModule(@RequestBody List<String> module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.postForObject(moduleURL + "/module" + "Activate", module_id,
					ServiceResponse.class);

		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to Fetch");
		}
		return serviceResponse;

	}

	// Method to Deactivate Module
	@PostMapping(value = "/moduleDeactivate")
	public ServiceResponse deactivateModule(@RequestBody List<String> module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.postForObject(moduleURL + "/module" + "Deactivate", module_id,
					ServiceResponse.class);

		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to Fetch");
		}
		return serviceResponse;

	}

	// ----------------------------------REPORT----------------------------------

	@PostMapping(value = "/report")
	public ServiceResponse createReport(@RequestBody Report report) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(moduleURL + "/report", report, ServiceResponse.class);
	}

	@GetMapping(value = "/report")
	public ServiceResponse getReportList() {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/report", ServiceResponse.class);
		return serviceResponse;
	}

	@GetMapping(value = "/report/{report_id}")
	public ServiceResponse getReportById(@PathVariable("report_id") String report_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/report" + "/" + report_id,
				ServiceResponse.class);
		return serviceResponse;

	}

	@GetMapping(value = "/reportByModule/{module_id}")
	public ServiceResponse getReportByModuleId(@PathVariable("module_id") String module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate
				.getForObject(moduleURL + "/report" + "ByModule" + "/" + module_id, ServiceResponse.class);
		return serviceResponse;
	}

	@PutMapping(value = "/report")
	public ServiceResponse updateReport(@RequestBody Report report) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			restTemplate.put(moduleURL + "/report", report);
			serviceResponse = restTemplate.getForObject(moduleURL + "/report" + "/" + report.getReport_id(),
					ServiceResponse.class);
			serviceResponse.setError(false);
			serviceResponse.setMessage("Report updated");
		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Updation Failed");
			;
		}
		return serviceResponse;
	}

	@DeleteMapping(value = "/report/{report_id}")
	public ServiceResponse deleteReport(@PathVariable("report_id") String report_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.getForObject(moduleURL + "/report" + "/" + report_id, ServiceResponse.class);
			restTemplate.delete(moduleURL + "/report/" + report_id);
			serviceResponse.setError(false);
			serviceResponse.setMessage("Report deleted");
		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Report does not exist");
		}
		return serviceResponse;
	}

	// Method to Activate Report
	@PostMapping(value = "/reportActivate")
	public ServiceResponse activateReport(@RequestBody List<String> module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.postForObject(moduleURL + "/report" + "Activate", module_id,
					ServiceResponse.class);

		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to Fetch");
		}
		return serviceResponse;

	}

	// Method to Deactivate Report
	@PostMapping(value = "/reportDeactivate")
	public ServiceResponse deactivatereport(@RequestBody List<String> module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.postForObject(moduleURL + "/report" + "Deactivate", module_id,
					ServiceResponse.class);

		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to Fetch");
		}
		return serviceResponse;

	}

	// ---------------------------------TRANSACTION-------------------------------

	// Method to create transaction
	@PostMapping(value = "/transaction")
	public ServiceResponse createTransaction(@RequestBody Transactions transactions) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.postForObject(moduleURL + "/transaction", transactions,
				ServiceResponse.class);
		return serviceResponse;
	}

	// Method to create transaction
	@PostMapping(value = "/transactionList")
	public ServiceResponse createTransactionList(@RequestBody List<Transactions> transactions) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.postForObject(moduleURL + "/transaction" + "List", transactions,
				ServiceResponse.class);
		return serviceResponse;
	}

	// Method to get all transaction
	@GetMapping(value = "/transaction")
	public ServiceResponse getTransactionList() {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/transaction", ServiceResponse.class);
		return serviceResponse;
	}

	// Method to get transaction by id
	@GetMapping(value = "/transaction/{transaction_id}")
	public ServiceResponse getTransactionById(@PathVariable("transaction_id") String transaction_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/transaction" + "/" + transaction_id,
				ServiceResponse.class);
		return serviceResponse;

	}

	@GetMapping(value = "/transactionByModule/{module_id}")
	public ServiceResponse getTransactionByModuleId(@PathVariable("module_id") String module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse = restTemplate.getForObject(moduleURL + "/transaction" + "ByModule" + "/" + module_id,
				ServiceResponse.class);
		return serviceResponse;
	}

	@PutMapping(value = "/transaction")
	public ServiceResponse updateTransaction(@RequestBody Transactions transactions) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			restTemplate.put(moduleURL + "/transaction", transactions);
			serviceResponse = restTemplate.getForObject(
					moduleURL + "/transaction" + "/" + transactions.getTransaction_id(), ServiceResponse.class);
			serviceResponse.setError(false);
			serviceResponse.setMessage("Transaction updated");
		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to fetch");
		}
		return serviceResponse;
	}

	@DeleteMapping(value = "/transaction/{transaction_id}")
	public ServiceResponse deleteTransaction(@PathVariable("transaction_id") String transaction_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.getForObject(moduleURL + "/transaction" + "/" + transaction_id,
					ServiceResponse.class);
			restTemplate.delete(moduleURL + "/transaction/" + transaction_id);
			serviceResponse.setError(false);
			serviceResponse.setMessage("Transaction Deleted");
		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Transaction does not exist");
		}

		return serviceResponse;
	}

	@DeleteMapping(value = "/transactionByModule/{module_id}")
	public ServiceResponse deleteTransactionByModule(@PathVariable("module_id") String module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.getForObject(moduleURL + "/transaction" + "ByModule/" + module_id,
					ServiceResponse.class);
			if (!serviceResponse.getMessage().equals("Transaction does not exist")) {
				restTemplate.delete(moduleURL + "/transaction" + "ByModule/" + module_id);
				serviceResponse.setError(false);
				serviceResponse.setMessage("Transaction Deleted");
			}
		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Fail to Fetch");
		}

		return serviceResponse;
	}

	// Method to Activate Report
	@PostMapping(value = "/transactionActivate")
	public ServiceResponse activateTransaction(@RequestBody List<String> module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.postForObject(moduleURL + "/transaction" + "Activate", module_id,
					ServiceResponse.class);

		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to Fetch");
		}
		return serviceResponse;

	}

	// Method to Deactivate Report
	@PostMapping(value = "/transactionDeactivate")
	public ServiceResponse deactivateTransaction(@RequestBody List<String> module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		try {
			serviceResponse = restTemplate.postForObject(moduleURL + "/transaction" + "Deactivate", module_id,
					ServiceResponse.class);

		} catch (Exception e) {
			e.printStackTrace();
			serviceResponse.setError(true);
			serviceResponse.setMessage("Failed to Fetch");
		}
		return serviceResponse;

	}

	@PostMapping(value = "/transList", consumes = "application/json")
	public JsonResponse getAllTransListByModuleId(@RequestBody ModelMap model)
			throws JsonParseException, JsonMappingException, IOException {

		JsonResponse response = new JsonResponse();
		RestTemplate restTemplate = new RestTemplate();

		ServiceResponse serviceResponse = restTemplate.getForObject(
				moduleURL + "/transaction" + "ByModule/" + model.get("module_id").toString(), ServiceResponse.class);
		ObjectMapper mapper = new ObjectMapper();
		ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
		String actjson = ow.writeValueAsString(serviceResponse.getResponsedata());

		List<Transactions> transacList = mapper.readValue(actjson,
				mapper.getTypeFactory().constructCollectionType(List.class, Transactions.class));

		ArrayList<HashMap<String, Object>> outer = new ArrayList<HashMap<String, Object>>();

		for (int i = 0; i < transacList.size(); i++) {
			HashMap<String, Object> inner = new HashMap<String, Object>();
			System.out.println(transacList.size());
			System.out.println(transacList.get(i));
			String actUpdate = "<button type = 'button' class='edit_btn' data-id ='"
					+ transacList.get(i).getTransaction_id()
					+ "' tittle='Suspend'><em class='fa fa-edit'></em></button>";
			inner.put("id", transacList.get(i).getTransaction_id().toString());
			inner.put("name", transacList.get(i).getTransaction_name().toString());
			if (transacList.get(i).getIsActive() == 1) {
				inner.put("status", "Active");
			} else {
				inner.put("status", "InActive");
			}
			inner.put("action", actUpdate);

			System.out.println(inner.size() > 0);
			if (inner.size() > 0) {
				outer.add(inner);
			}
		}
		response.setResult(outer);
		return response;
	}

	@GetMapping(value = "/moduleActive")
	public ServiceResponse getActiveModuleList() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(moduleURL + "/moduleActivatedList", ServiceResponse.class);
	}

}
