package com.kirat.tm.dto;


public class RoleResponseDto {
	private String message;

	private Role responsedata;

	private String error;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Role getResponsedata() {
		return responsedata;
	}

	public void setResponsedata(Role responsedata) {
		this.responsedata = responsedata;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public String toString() {
		return "ClassPojo [message = " + message + ", responsedata = " + responsedata + ", error = " + error + "]";
	}
}
