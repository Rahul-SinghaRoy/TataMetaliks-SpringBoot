package com.kirat.tm.model;

import java.sql.Timestamp;

public class GraphData {

	private int id;

	private String projectid;

	private String mnth;

	private String crntyr;

	private String mnthplan;

	private String cummplan;

	private String mnthachv;

	private String cummachv;
	
	private String catg;
	
	private String other;

	private Timestamp createddate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getMnth() {
		return mnth;
	}

	public void setMnth(String mnth) {
		this.mnth = mnth;
	}

	public String getCrntyr() {
		return crntyr;
	}

	public void setCrntyr(String crntyr) {
		this.crntyr = crntyr;
	}

	public String getMnthplan() {
		return mnthplan;
	}

	public void setMnthplan(String mnthplan) {
		this.mnthplan = mnthplan;
	}

	public String getCummplan() {
		return cummplan;
	}

	public void setCummplan(String cummplan) {
		this.cummplan = cummplan;
	}

	public String getMnthachv() {
		return mnthachv;
	}

	public void setMnthachv(String mnthachv) {
		this.mnthachv = mnthachv;
	}

	public String getCummachv() {
		return cummachv;
	}

	public void setCummachv(String cummachv) {
		this.cummachv = cummachv;
	}
	
	

	public String getCatg() {
		return catg;
	}

	public void setCatg(String catg) {
		this.catg = catg;
	}

	public Timestamp getCreateddate() {
		return createddate;
	}

	public void setCreateddate(Timestamp createddate) {
		this.createddate = createddate;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

}
