package com.kirat.tm.dto;


public class ModuleResponseData {
	private String module_id;

	private String createdate;

	private String updatedate;

	private String module_name;
	
	private int IsActive;

	public String getModule_id() {
		return module_id;
	}

	public void setModule_id(String module_id) {
		this.module_id = module_id;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	public String getModule_name() {
		return module_name;
	}

	public void setModule_name(String module_name) {
		this.module_name = module_name;
	}

	

	public int getIsActive() {
		return IsActive;
	}

	public void setIsActive(int isActive) {
		IsActive = isActive;
	}

	@Override
	public String toString() {
		return "ClassPojo [module_id = " + module_id + ", createdate = " + createdate + ", updatedate = " + updatedate
				+ ", module_name = " + module_name + "]";
	}
}
