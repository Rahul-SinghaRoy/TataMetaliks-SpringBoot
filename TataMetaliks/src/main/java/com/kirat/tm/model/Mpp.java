package com.kirat.tm.model;

import java.sql.Date;

public class Mpp {
	private String projectid;
	private int serialnumber;
	private String projectname;
	private String duration;
	private Date start;
	private Date finish;
	private Date actualstart;
	private Date actualfinish;
	private String totalslack;
	private String percentagework;
	private String projectref;
	private String resourcename;
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public int getSerialnumber() {
		return serialnumber;
	}
	public void setSerialnumber(int serialnumber) {
		this.serialnumber = serialnumber;
	}
	public String getProjectname() {
		return projectname;
	}
	public void setProjectname(String projectname) {
		this.projectname = projectname;
	}
	public String getDuration() {
		return duration;
	}
	public void setDuration(String duration) {
		this.duration = duration;
	}
	public Date getStart() {
		return start;
	}
	public void setStart(Date start) {
		this.start = start;
	}
	public Date getFinish() {
		return finish;
	}
	public void setFinish(Date finish) {
		this.finish = finish;
	}
	public Date getActualstart() {
		return actualstart;
	}
	public void setActualstart(Date actualstart) {
		this.actualstart = actualstart;
	}
	public Date getActualfinish() {
		return actualfinish;
	}
	public void setActualfinish(Date actualfinish) {
		this.actualfinish = actualfinish;
	}
	public String getTotalslack() {
		return totalslack;
	}
	public void setTotalslack(String totalslack) {
		this.totalslack = totalslack;
	}
	public String getPercentagework() {
		return percentagework;
	}
	public void setPercentagework(String percentagework) {
		this.percentagework = percentagework;
	}
	public String getProjectref() {
		return projectref;
	}
	public void setProjectref(String projectref) {
		this.projectref = projectref;
	}
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
 
	
}
