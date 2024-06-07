package com.kirat.tm.dto;

import com.kirat.tm.model.Transactions;

public class TransactionListDto {
	private String message;

	private Transactions[] responsedata;

	private String error;

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Transactions[] getResponsedata() {
		return responsedata;
	}

	public void setResponsedata(Transactions[] responsedata) {
		this.responsedata = responsedata;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
