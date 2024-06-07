package com.kirat.tm.model;

public class ServiceResponse {
Object responsedata;
boolean error;
String message;
public Object getResponsedata() {
	return responsedata;
}
public void setResponsedata(Object responsedata) {
	this.responsedata = responsedata;
}
public boolean isError() {
	return error;
}
public void setError(boolean error) {
	this.error = error;
}
public String getMessage() {
	return message;
}
public void setMessage(String message) {
	this.message = message;
}

}
