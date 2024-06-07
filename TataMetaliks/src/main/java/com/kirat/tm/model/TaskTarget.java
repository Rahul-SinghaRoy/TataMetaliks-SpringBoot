package com.kirat.tm.model;

import java.sql.Date;

public class TaskTarget {
	private int serial;
public int getSerial() {
		return serial;
	}
	public void setSerial(int serial) {
		this.serial = serial;
	}
private String taskid;
private String tasktype; 
private String taskname;
private String reponibleperon;
private String status;
private Date startdate;
private Date enddate;
private Date astartdate;
private Date aenddate;


public Date getAstartdate() {
	return astartdate;
}
public void setAstartdate(Date astartdate) {
	this.astartdate = astartdate;
}
public Date getAenddate() {
	return aenddate;
}
public void setAenddate(Date aenddate) {
	this.aenddate = aenddate;
}
public String getTaskid() {
	return taskid;
}
public void setTaskid(String taskid) {
	this.taskid = taskid;
}

public String getTasktype() {
	return tasktype;
}
public void setTasktype(String tasktype) {
	this.tasktype = tasktype;
}
public String getTaskname() {
	return taskname;
}
public void setTaskname(String taskname) {
	this.taskname = taskname;
}
public String getReponibleperon() {
	return reponibleperon;
}
public void setReponibleperon(String reponibleperon) {
	this.reponibleperon = reponibleperon;
}
public String getStatus() {
	return status;
}
public void setStatus(String status) {
	this.status = status;
}
public Date getStartdate() {
	return startdate;
}
public void setStartdate(Date startdate) {
	this.startdate = startdate;
}
public Date getEnddate() {
	return enddate;
}
public void setEnddate(Date enddate) {
	this.enddate = enddate;
}


}
