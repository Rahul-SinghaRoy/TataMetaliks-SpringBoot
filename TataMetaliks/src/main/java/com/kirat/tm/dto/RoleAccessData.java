package com.kirat.tm.dto;

public class RoleAccessData {
	private String roleid;

	private String createdate;

	private String moduleid;

	private String accessid;

	private String updatedate;

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getCreatedate() {
		return createdate;
	}

	public void setCreatedate(String createdate) {
		this.createdate = createdate;
	}

	public String getModuleid() {
		return moduleid;
	}

	public void setModuleid(String moduleid) {
		this.moduleid = moduleid;
	}

	public String getAccessid() {
		return accessid;
	}

	public void setAccessid(String accessid) {
		this.accessid = accessid;
	}

	public String getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(String updatedate) {
		this.updatedate = updatedate;
	}

	@Override
	public String toString() {
		return "ClassPojo [roleid = " + roleid + ", createdate = " + createdate + ", moduleid = " + moduleid
				+ ", accessid = " + accessid + ", updatedate = " + updatedate + "]";
	}
}
