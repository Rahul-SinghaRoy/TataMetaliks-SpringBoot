package com.kirat.tm.dto;

public class RoleAccessDto {
	private String message;

	private RoleAccessData[] responsedata;

	private String error;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public RoleAccessData[] getResponsedata() {
		return responsedata;
	}

	public void setResponsedata(RoleAccessData[] responsedata) {
		this.responsedata = responsedata;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
