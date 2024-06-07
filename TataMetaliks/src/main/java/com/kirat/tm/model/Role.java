package com.kirat.tm.model;


import java.util.Date;



public class Role {
	
	
	private String roleid;
	
	private String rolename;
	
	private String groupid;
	
	private String typeid;
	
    private Date createdate;
	
    private Date updatedate;
	//private String rlicn;
	public String getRoleid() {
		return roleid;
	}
	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}
	public String getRolename() {
		return rolename;
	}
	public void setRolename(String rolename) {
		this.rolename = rolename;
	}
	public String getGroupid() {
		return groupid;
	}
	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}
	public String getTypeid() {
		return typeid;
	}
	public void setTypeid(String typeid) {
		this.typeid = typeid;
	}
	public Date getCreatedate() {
		return createdate;
	}
	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}
	public Date getUpdatedate() {
		return updatedate;
	}
	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}
//	public String getRlicn() {
//		return rlicn;
//	}
//	public void setRlicn(String rlicn) {
//		this.rlicn = rlicn;
//	}
}