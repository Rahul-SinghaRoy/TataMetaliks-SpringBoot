package com.kirat.tm.model;

public class ProjectSummaryPO {
	
	private Integer id;
	
	private String summaryid;
	
	private int reportnumber;
	
	private String projectid;
	
	private String potype;
	
	private Integer poamount;
	
	private Integer paymentdone;
	
	private String remarks;
	
	private String poamountunit;
	
	private String paymentdoneunit;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getSummaryid() {
		return summaryid;
	}
	public void setSummaryid(String summaryid) {
		this.summaryid = summaryid;
	}
	public int getReportnumber() {
		return reportnumber;
	}
	public void setReportnumber(int reportnumber) {
		this.reportnumber = reportnumber;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getPotype() {
		return potype;
	}
	public void setPotype(String potype) {
		this.potype = potype;
	}
	public Integer getPoamount() {
		return poamount;
	}
	public void setPoamount(Integer poamount) {
		this.poamount = poamount;
	}
	public Integer getPaymentdone() {
		return paymentdone;
	}
	public void setPaymentdone(Integer paymentdone) {
		this.paymentdone = paymentdone;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	

	public String getPoamountunit() {
		return poamountunit;
	}

	public void setPoamountunit(String poamountunit) {
		this.poamountunit = poamountunit;
	}

	public String getPaymentdoneunit() {
		return paymentdoneunit;
	}

	public void setPaymentdoneunit(String paymentdoneunit) {
		this.paymentdoneunit = paymentdoneunit;
	}
	
}
