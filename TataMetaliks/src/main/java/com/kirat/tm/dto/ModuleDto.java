package com.kirat.tm.dto;

import com.kirat.tm.model.Module;

public class ModuleDto {
	private String message;

	private Module responsedata;

	private String error;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Module getResponsedata() {
		return responsedata;
	}

	public void setResponsedata(Module responsedata) {
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
