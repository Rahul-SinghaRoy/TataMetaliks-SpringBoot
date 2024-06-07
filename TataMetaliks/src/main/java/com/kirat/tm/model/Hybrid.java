package com.kirat.tm.model;

import java.sql.Date;

public class Hybrid {
	
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
	private String taskid;
	private String taskname;
	private String ptaskid;
	
	private String level;
	private String parent;
	private boolean IsLeaf;
	private boolean expanded;
	private boolean loaded;
	private String resourcename;
	
	private String as;
	private String af;
	
	
	
	
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
	public String getTaskid() {
		return taskid;
	}
	public void setTaskid(String taskid) {
		this.taskid = taskid;
	}
	public String getTaskname() {
		return taskname;
	}
	public void setTaskname(String taskname) {
		this.taskname = taskname;
	}
	public String getPtaskid() {
		return ptaskid;
	}
	public void setPtaskid(String ptaskid) {
		this.ptaskid = ptaskid;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getParent() {
		return parent;
	}
	public void setParent(String parent) {
		this.parent = parent;
	}
	
	public boolean isIsLeaf() {
		return IsLeaf;
	}
	public void setIsLeaf(boolean isLeaf) {
		IsLeaf = isLeaf;
	}
	public boolean isExpanded() {
		return expanded;
	}
	public void setExpanded(boolean expanded) {
		this.expanded = expanded;
	}
	public boolean isLoaded() {
		return loaded;
	}
	public void setLoaded(boolean loaded) {
		this.loaded = loaded;
	}
	public String getResourcename() {
		return resourcename;
	}
	public void setResourcename(String resourcename) {
		this.resourcename = resourcename;
	}
	public String getAs() {
		return as;
	}
	public void setAs(String as) {
		this.as = as;
	}
	public String getAf() {
		return af;
	}
	public void setAf(String af) {
		this.af = af;
	}
	

}
