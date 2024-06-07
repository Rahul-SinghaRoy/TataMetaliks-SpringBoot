package com.kirat.tm.dto;


public class ReportListDto {
	private String message;

	private ReportResponse[] responsedata;

	private String error;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public ReportResponse[] getResponsedata() {
		return responsedata;
	}

	public void setResponsedata(ReportResponse[] responsedata) {
		this.responsedata = responsedata;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
