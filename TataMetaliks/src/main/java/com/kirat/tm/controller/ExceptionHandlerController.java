package com.kirat.tm.controller;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Date;

//import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirat.tm.model.ERRMOD;
import com.kirat.tm.model.ExceptionLog;


@ControllerAdvice
public class ExceptionHandlerController {
	//@Inject
	//ExceptionLog exceptionLog;
	public static final String DEFAULT_ERROR_VIEW = "serviceError";

	@ExceptionHandler(value = { Exception.class, RuntimeException.class })
	public ModelAndView defaultErrorHandler(HttpServletRequest request,
			Exception e) throws JsonProcessingException {
		System.out.println("Global Exception");
		//System.out.println(e);
		//e.printStackTrace(System.out);
		//exceptionLog.getRequestObject();
		e.printStackTrace(System.out);
		ERRMOD errmod=new ERRMOD();
		errmod.setERRKEY(new Date().toString());
		errmod.setAPP("TM");
		StringWriter sw = new StringWriter();
		PrintWriter pw = new PrintWriter(sw);
		e.printStackTrace(pw);
		String sStackTrace = sw.toString();
		//errmod.setERREXCP(sStackTrace);
		//errmod.setERROBJ(exceptionLog.getRequestObject());
		ObjectMapper objectMapper = new ObjectMapper();
		String jsonInString2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(errmod);
		//api call
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		HttpEntity<String> entity = new HttpEntity<String>(jsonInString2, headers);
		String answer = restTemplate.postForObject("http://14.141.110.54:8080/ERAPI/storeLog/TM", entity, String.class);
		System.out.println(answer);
		//Status st1 = mapper.readValue(answer, Status.class);
		
		
		System.out.println(jsonInString2);
		Status st = new Status();
		st.setCode("System Error");
		st.setMessage("There has been a system error occurred");
		ModelAndView mav = new ModelAndView(DEFAULT_ERROR_VIEW, "statuscommand", st);
		return mav;
	}
}
