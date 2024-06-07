package com.kirat.tm.utils;

import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.kirat.tm.constants.OLCProp;
import com.kirat.tm.model.LogData;


public  class LogFilter implements Filter {

	public String logURL = OLCUtil.getValue(OLCProp.URL_OF_WEBAUDITSERVICE);
	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		 RequestWrapper requestWrapper = new RequestWrapper((HttpServletRequest) request);
		// ResponseWrapper responseWrapper = new ResponseWrapper ((HttpServletResponse) response);
		HttpServletRequest req = (HttpServletRequest) request;
		Map<String, String> map = new HashMap<String, String>();
			try {
				
		       Enumeration headerNames = req.getHeaderNames();
		        while (headerNames.hasMoreElements()) {
		            String key = (String) headerNames.nextElement();
		            String value = req.getHeader(key);
		            map.put(key, value);
		        }
			System.out.println(map); 
			String body =requestWrapper.getBody();
			String reqFromUrl=req.getRequestURL().toString();
		    String  url=map.get("referer").toString();  
			RestTemplate restTemplate = new RestTemplate();
			ObjectMapper objectMapper = new ObjectMapper();
			LogData logData = new LogData();
			logData.setUser_Token(req.getHeader("token"));
			logData.setRequest_Data(body);
			logData.setRequest_Url(reqFromUrl);
			logData.setRequestFrom_Url(url);
			logData.setRequest_App("TataMetaliks"); 
			logData.setRequest_Method(req.getMethod().toString()); 
			String jsonInString2 = objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(logData);
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			HttpEntity<String> entity = new HttpEntity<String>(jsonInString2, headers);
			String result=restTemplate.postForObject(logURL + "/logSaver", entity, String.class);
			chain.doFilter(requestWrapper, response);
		} finally {
			//MDC.remove("userName");
		}

	}
	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}

}