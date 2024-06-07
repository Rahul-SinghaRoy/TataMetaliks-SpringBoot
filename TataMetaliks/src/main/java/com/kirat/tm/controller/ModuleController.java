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
import com.kirat.tm.model.JsonResponse;
import com.kirat.tm.model.Module;
import com.kirat.tm.model.Report;
import com.kirat.tm.model.ServiceResponse;
import com.kirat.tm.model.Transactions;
import com.kirat.tm.utils.OLCUtil;

@Controller
@EnableWebMvc
public class ModuleController {

	public String moduleURL = OLCUtil.getValue(OLCProp.URL_OF_MODULESERVICE);

	// Method to create Module
	@RequestMapping(value = "/module", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse createModule(@RequestBody Module module) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.postForObject(moduleURL + "/module", module,
				ServiceResponse.class);
		return serviceResponse;
	}

	// Method to get all modules
	@RequestMapping(value = "/module", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getModuleList() {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/module", ServiceResponse.class);
		return serviceResponse;
	}

	@RequestMapping(value = "/moduleList", method = RequestMethod.GET, consumes = "application/json")
	public @ResponseBody JsonResponse getAllmoduleList() throws JsonParseException, JsonMappingException, IOException {

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
	@RequestMapping(value = "/module/{module_id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getModuleById(@PathVariable("module_id") String module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/module" + "/" + module_id,
				ServiceResponse.class);
		return serviceResponse;

	}

	// Method to update module
	@RequestMapping(value = "/module", method = RequestMethod.PUT)
	public @ResponseBody ServiceResponse updateModule(@RequestBody Module module) {
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
	@RequestMapping(value = "/module/{module_id}", method = RequestMethod.DELETE)
	public @ResponseBody ServiceResponse deleteModule(@PathVariable("module_id") String module_id) {
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
	@RequestMapping(value = "/moduleActivate", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse activateModule(@RequestBody List<String> module_id) {
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
	@RequestMapping(value = "/moduleDeactivate", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse deactivateModule(@RequestBody List<String> module_id) {
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

	@RequestMapping(value = "/report", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse createReport(@RequestBody Report report) {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.postForObject(moduleURL + "/report", report, ServiceResponse.class);
	}

	@RequestMapping(value = "/report", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getReportList() {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/report", ServiceResponse.class);
		return serviceResponse;
	}

	@RequestMapping(value = "/report/{report_id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getReportById(@PathVariable("report_id") String report_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/report" + "/" + report_id,
				ServiceResponse.class);
		return serviceResponse;

	}

	@RequestMapping(value = "/reportByModule/{module_id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getReportByModuleId(@PathVariable("module_id") String module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate
				.getForObject(moduleURL + "/report" + "ByModule" + "/" + module_id, ServiceResponse.class);
		return serviceResponse;
	}

	@RequestMapping(value = "/report", method = RequestMethod.PUT)
	public @ResponseBody ServiceResponse updateReport(@RequestBody Report report) {
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

	@RequestMapping(value = "/report/{report_id}", method = RequestMethod.DELETE)
	public @ResponseBody ServiceResponse deleteReport(@PathVariable("report_id") String report_id) {
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
	@RequestMapping(value = "/reportActivate", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse activateReport(@RequestBody List<String> module_id) {
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
	@RequestMapping(value = "/reportDeactivate", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse deactivatereport(@RequestBody List<String> module_id) {
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
	@RequestMapping(value = "/transaction", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse createTransaction(@RequestBody Transactions transactions) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.postForObject(moduleURL + "/transaction", transactions,
				ServiceResponse.class);
		return serviceResponse;
	}

	// Method to create transaction
	@RequestMapping(value = "/transactionList", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse createTransactionList(@RequestBody List<Transactions> transactions) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.postForObject(moduleURL + "/transaction" + "List", transactions,
				ServiceResponse.class);
		return serviceResponse;
	}

	// Method to get all transaction
	@RequestMapping(value = "/transaction", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getTransactionList() {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/transaction", ServiceResponse.class);
		return serviceResponse;
	}

	// Method to get transaction by id
	@RequestMapping(value = "/transaction/{transaction_id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getTransactionById(@PathVariable("transaction_id") String transaction_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = restTemplate.getForObject(moduleURL + "/transaction" + "/" + transaction_id,
				ServiceResponse.class);
		return serviceResponse;

	}

	@RequestMapping(value = "/transactionByModule/{module_id}", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getTransactionByModuleId(@PathVariable("module_id") String module_id) {
		RestTemplate restTemplate = new RestTemplate();
		ServiceResponse serviceResponse = new ServiceResponse();
		serviceResponse = restTemplate.getForObject(moduleURL + "/transaction" + "ByModule" + "/" + module_id,
				ServiceResponse.class);
		return serviceResponse;
	}

	@RequestMapping(value = "/transaction", method = RequestMethod.PUT)
	public @ResponseBody ServiceResponse updateTransaction(@RequestBody Transactions transactions) {
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

	@RequestMapping(value = "/transaction/{transaction_id}", method = RequestMethod.DELETE)
	public @ResponseBody ServiceResponse deleteTransaction(@PathVariable("transaction_id") String transaction_id) {
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

	@RequestMapping(value = "/transactionByModule/{module_id}", method = RequestMethod.DELETE)
	public @ResponseBody ServiceResponse deleteTransactionByModule(@PathVariable("module_id") String module_id) {
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
	@RequestMapping(value = "/transactionActivate", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse activateTransaction(@RequestBody List<String> module_id) {
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
	@RequestMapping(value = "/transactionDeactivate", method = RequestMethod.POST)
	public @ResponseBody ServiceResponse deactivateTransaction(@RequestBody List<String> module_id) {
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

	@RequestMapping(value = "/transList", method = RequestMethod.POST, consumes = "application/json")
	public @ResponseBody JsonResponse getAllTransListByModuleId(@RequestBody ModelMap model)
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

	@RequestMapping(value = "/moduleActive", method = RequestMethod.GET)
	public @ResponseBody ServiceResponse getActiveModuleList() {
		RestTemplate restTemplate = new RestTemplate();
		return restTemplate.getForObject(moduleURL + "/moduleActivatedList", ServiceResponse.class);
	}

}
