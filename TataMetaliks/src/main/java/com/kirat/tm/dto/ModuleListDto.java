package com.kirat.tm.dto;

public class ModuleListDto {
	private String message;

	private ModuleResponseData[] responsedata;

	private String error;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ModuleResponseData[] getResponsedata() {
		return responsedata;
	}

	public void setResponsedata(ModuleResponseData[] responsedata) {
		this.responsedata = responsedata;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
