package com.kirat.tm.model;

import java.sql.Timestamp;

public class ProjectSheetMaster {
	
	private String masterid;
	private String projectid;
    private String sheetname;
    private String tablename;
    private String excelfilename;
	private int ver_sion;
    private String tittle;
    private Timestamp updatedon;
  
	public String getTittle() {
		return tittle;
	}
	public void setTittle(String tittle) {
		this.tittle = tittle;
	}
	public String getMasterid() {
		return masterid;
	}
	public void setMasterid(String masterid) {
		this.masterid = masterid;
	}
	public String getProjectid() {
		return projectid;
	}
	public void setProjectid(String projectid) {
		this.projectid = projectid;
	}
	public String getSheetname() {
		return sheetname;
	}
	public void setSheetname(String sheetname) {
		this.sheetname = sheetname;
	}
	public String getTablename() {
		return tablename;
	}
	public void setTablename(String tablename) {
		this.tablename = tablename;
	}
	public String getExcelfilename() {
		return excelfilename;
	}
	public void setExcelfilename(String excelfilename) {
		this.excelfilename = excelfilename;
	}
	
	public int getVer_sion() {
		return ver_sion;
	}
	public void setVer_sion(int ver_sion) {
		this.ver_sion = ver_sion;
	}
	public Timestamp getUpdatedon() {
		return updatedon;
	}
	public void setUpdatedon(Timestamp updatedon) {
		this.updatedon = updatedon;
	}
	
	
}
