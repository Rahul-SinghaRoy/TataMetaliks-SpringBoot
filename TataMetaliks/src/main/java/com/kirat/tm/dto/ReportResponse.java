package com.kirat.tm.dto;

public class ReportResponse {
	private String isActive;

	private String module_id;

	private String report_name;

	private String createdate;

	private String report_id;

	private String updatedate;

	public String getIsActive() {
		return isActive;
	}

	public void setIsActive(String isActive) {
		this.isActive = isActive;
	}

	public String getModule_id() {
		return module_id;
	}

	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}

	public String getReport_name() {
		return report_name;
	}

	public void setReport_name(String report_name) {
		this.report_name = report_name;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getReport_id() {
		return report_id;
	}

	public void setReport_id(String report_id) {
		this.report_id = report_id;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "ClassPojo [isActive = " + isActive + ", module_id = " + module_id + ", report_name = " + report_name
				+ ", createdate = " + createdate + ", report_id = " + report_id + ", updatedate = " + updatedate + "]";
	}
}
