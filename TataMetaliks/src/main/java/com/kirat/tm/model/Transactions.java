package com.kirat.tm.model;

import java.io.Serializable;
import java.util.Date;




public class Transactions implements Serializable {

	private static final long serialVersionUID = 1L;

	
	private String transaction_id;
	
	private String transaction_name;
	
	private String module_id;
	
	private Date createdate;
	
	private Date updatedate;
	
	private int isActive;

	public Transactions() {

	}

	public String getTransaction_id() {
		return transaction_id;
	}

	public void setTransaction_id(String transaction_id) {
		this.transaction_id = transaction_id;
	}

	public String getTransaction_name() {
		return transaction_name;
	}

	public void setTransaction_name(String transaction_name) {
		this.transaction_name = transaction_name;
	}

	public String getModule_id() {
		return module_id;
	}

	public void setModule_id(String module_id) {
		this.module_id = module_id;
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

	public int getIsActive() {
		return isActive;
	}

	public void setIsActive(int isActive) {
		this.isActive = isActive;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
}
