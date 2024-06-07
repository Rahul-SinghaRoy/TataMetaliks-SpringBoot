package com.kirat.tm.model;


import java.sql.Date;

public class Profile {
	private String id;

	private String phone;

	private String lname;

	private String roleid;

	private String email;

	private String typeid;

	private Date createdate;

	private String groupid;

	private Date updatedate;

	private String password;

	private String fname;

	private int isActive;

	private String token;
	
	private String otp;
	private Date otpexpdt;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getRoleid() {
		return roleid;
	}

	public void setRoleid(String roleid) {
		this.roleid = roleid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
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

	public String getGroupid() {
		return groupid;
	}

	public void setGroupid(String groupid) {
		this.groupid = groupid;
	}

	public Date getUpdatedate() {
		return updatedate;
	}

	public void setUpdatedate(Date updatedate) {
		this.updatedate = updatedate;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	
	
	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public Date getOtpexpdt() {
		return otpexpdt;
	}

	public void setOtpexpdt(Date otpexpdt) {
		this.otpexpdt = otpexpdt;
	}

	@Override
	public String toString() {
		return "Profile [id=" + id + ", phone=" + phone + ", lname=" + lname + ", roleid=" + roleid + ", email=" + email
				+ ", typeid=" + typeid + ", createdate=" + createdate + ", groupid=" + groupid + ", updatedate="
				+ updatedate + ", password=" + password + ", fname=" + fname + ", isActive=" + isActive + ", token="
				+ token + ", otp=" + otp + ", otpexpdt=" + otpexpdt + "]";
	}

	
	
	
	/*@Override
	public String toString() {
		return "ClassPojo [isActive = " + isActive + ", id = " + id + ", phone = " + phone + ", lname = " + lname
				+ ", roleid = " + roleid + ", email = " + email + ", typeid = " + typeid + ", createdate = "
				+ createdate + ", groupid = " + groupid + ", updatedate = " + updatedate + ", password = " + password
				+ ", fname = " + fname + "]";
	}*/
}
