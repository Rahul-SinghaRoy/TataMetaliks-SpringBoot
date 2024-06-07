package com.kirat.tm.dto;

import java.util.List;

import com.kirat.tm.model.Role;

//import com.kirat.otpl.model.Role;

public class RoleListDto {
	private String message;

	private Role[] responsedata;

	private String error;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Role[] getResponsedata() {
		return responsedata;
	}

	public void setResponsedata(Role[] responsedata) {
		this.responsedata = responsedata;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
