package com.kirat.tm.model;

import java.sql.Timestamp;
import java.util.List;


public class ProjectSummary {
	private String summaryid;
	private String reportdate;
	private int reportnumber;
	private String tdc;
	private String ads;
	private String approvedbudget;
	private String ctdate;
	private String paymentstatus;
	private int poreleased;
	private String projectid;
	private String schdfinsh;
	private String forecstfinish;
	private Integer totalpo;
	private Integer revisedbudget;
	private Integer totalpaymentdone;
	private List<ProjectSummaryPO> podetails;
	private Timestamp created_at;
	private Timestamp updated_at;
	private String budgetunit;
	private String revisedunit;

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

	public String getReportdate() {
		return reportdate;
	}

	public void setReportdate(String reportdate) {
		this.reportdate = reportdate;
	}

	public String getTdc() {
		return tdc;
	}

	public void setTdc(String tdc) {
		this.tdc = tdc;
	}

	public String getAds() {
		return ads;
	}

	public void setAds(String ads) {
		this.ads = ads;
	}

	public String getApprovedbudget() {
		return approvedbudget;
	}

	public void setApprovedbudget(String approvedbudget) {
		this.approvedbudget = approvedbudget;
	}

	public String getCtdate() {
		return ctdate;
	}

	public void setCtdate(String ctdate) {
		this.ctdate = ctdate;
	}

	public String getPaymentstatus() {
		return paymentstatus;
	}

	public void setPaymentstatus(String paymentstatus) {
		this.paymentstatus = paymentstatus;
	}

	public int getPoreleased() {
		return poreleased;
	}

	public void setPoreleased(int poreleased) {
		this.poreleased = poreleased;
	}

	public String getProjectid() {
		return projectid;
	}

	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}

	public String getSchdfinsh() {
		return schdfinsh;
	}

	public void setSchdfinsh(String schdfinsh) {
		this.schdfinsh = schdfinsh;
	}

	public String getForecstfinish() {
		return forecstfinish;
	}

	public void setForecstfinish(String forecstfinish) {
		this.forecstfinish = forecstfinish;
	}

	public Integer getTotalpo() {
		return totalpo;
	}

	public void setTotalpo(Integer totalpo) {
		this.totalpo = totalpo;
	}

	public Integer getRevisedbudget() {
		return revisedbudget;
	}

	public void setRevisedbudget(Integer revisedbudget) {
		this.revisedbudget = revisedbudget;
	}

	public Integer getTotalpaymentdone() {
		return totalpaymentdone;
	}

	public void setTotalpaymentdone(Integer totalpaymentdone) {
		this.totalpaymentdone = totalpaymentdone;
	}

	public List<ProjectSummaryPO> getPodetails() {
		return podetails;
	}

	public void setPodetails(List<ProjectSummaryPO> podetails) {
		this.podetails = podetails;
	}

	public Timestamp getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Timestamp created_at) {
		this.created_at = created_at;
	}

	public Timestamp getUpdated_at() {
		return updated_at;
	}

	public void setUpdated_at(Timestamp updated_at) {
		this.updated_at = updated_at;
	}

	public String getBudgetunit() {
		return budgetunit;
	}

	public void setBudgetunit(String budgetunit) {
		this.budgetunit = budgetunit;
	}
	
	public String getRevisedunit() {
		return revisedunit;
	}

	public void setRevisedunit(String revisedunit) {
		this.revisedunit = revisedunit;
	}
	
	
}
