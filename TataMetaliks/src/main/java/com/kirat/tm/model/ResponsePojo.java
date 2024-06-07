package com.kirat.tm.model;



public class ResponsePojo {
	private Profile responsedata;
	private String error;
	private String message;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Profile getResponsedata() {
		return responsedata;
	}

	public void setResponsedata(Profile responsedata) {
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
