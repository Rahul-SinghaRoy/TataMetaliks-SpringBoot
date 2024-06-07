package com.kirat.tm.controller;

public class Status {

	private String msg_code;
	private String message;

	public Status() {
	}

	public Status(String msg_code, String message) {
		this.msg_code = msg_code;
		this.message = message;
	}

	public String getCode() {
		return msg_code;
	}

	public void setCode(String msg_code) {
		this.msg_code = msg_code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
