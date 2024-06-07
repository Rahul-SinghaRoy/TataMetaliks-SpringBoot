package com.kirat.tm.model;

import java.sql.Timestamp;

public class TaskManagement {

	private String taskid;
	
	private String projectid;
	
	private String assignby;
	
	private String assignto;
	
	private String taskname;
	
	private String taskdescription;
	
	private String taskstatus;
	
	private Timestamp createddate;
	
	private Timestamp closeddate;
	
	private String taskresponse;
	
	private String tasktype;

	public String getTaskid() {
		return taskid;
	}

	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getAssignby() {
		return assignby;
	}

	public void setAssignby(String assignby) {
		this.assignby = assignby;
	}

	public String getAssignto() {
		return assignto;
	}

	public void setAssignto(String assignto) {
		this.assignto = assignto;
	}

	public String getTaskname() {
		return taskname;
	}

	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}

	public String getTaskdescription() {
		return taskdescription;
	}

	public void setTaskdescription(String taskdescription) {
		this.taskdescription = taskdescription;
	}

	public String getTaskstatus() {
		return taskstatus;
	}

	public void setTaskstatus(String taskstatus) {
		this.taskstatus = taskstatus;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	public Timestamp getCloseddate() {
		return closeddate;
	}

	public void setCloseddate(Timestamp closeddate) {
		this.closeddate = closeddate;
	}

	public String getTaskresponse() {
		return taskresponse;
	}

	public void setTaskresponse(String taskresponse) {
		this.taskresponse = taskresponse;
	}

	public String getTasktype() {
		return tasktype;
	}

	public void setTasktype(String tasktype) {
		this.tasktype = tasktype;
	}
	
}
