package com.kirat.tm.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class LogData implements Serializable {
	private static final long serialVersionUID = 1L;
	private String RequestFrom_Url;
	private String Request_Url;
	private String User_Id;
	private String User_Token;
	private String Response_Url;
	private String Request_Data;
	private String Request_On;
	private String Request_App;
	private String Request_Method;
	private int Response_Status;
    private long Response_Time;
	
	
	public int getResponse_Status() {
		return Response_Status;
	}
	public void setResponse_Status(int response_Status) {
		Response_Status = response_Status;
	}
	public long getResponse_Time() {
		return Response_Time;
	}
	public void setResponse_Time(long response_Time) {
		Response_Time = response_Time;
	}
	public String getRequest_On() {
		return Request_On;
	}
	public void setRequest_On(String request_On) {
		Request_On = request_On;
	}
	public String getRequestFrom_Url() {
		return RequestFrom_Url;
	}
	public void setRequestFrom_Url(String requestFrom_Url) {
		RequestFrom_Url = requestFrom_Url;
	}
	public String getRequest_Url() {
		return Request_Url;
	}
	public void setRequest_Url(String request_Url) {
		Request_Url = request_Url;
	}
	public String getUser_Id() {
		return User_Id;
	}
	public void setUser_Id(String user_Id) {
		User_Id = user_Id;
	}
	public String getUser_Token() {
		return User_Token;
	}
	public void setUser_Token(String user_Token) {
		User_Token = user_Token;
	}
	public String getResponse_Url() {
		return Response_Url;
	}
	public void setResponse_Url(String response_Url) {
		Response_Url = response_Url;
	}
	public String getRequest_Data() {
		return Request_Data;
	}
	public void setRequest_Data(String request_Data) {
		Request_Data = request_Data;
	}
	public String getRequest_App() {
		return Request_App;
	}
	public void setRequest_App(String request_App) {
		Request_App = request_App;
	}
	public String getRequest_Method() {
		return Request_Method;
	}
	public void setRequest_Method(String request_Method) {
		Request_Method = request_Method;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
	