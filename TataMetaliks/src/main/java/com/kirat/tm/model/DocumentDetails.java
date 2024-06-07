package com.kirat.tm.model;

import java.io.Serializable;
import java.sql.Date;

public class DocumentDetails implements Serializable {
	private static final long serialVersionUID = 1L;

	private String DocumentId;

	private String CreatedBy;

	private String ProjectId;

	private String DocumentType;

	private String DocumentName;

	private Date CreatedDate;

	private String DocumentPath;

	private int VersionId;

	private String docstyle;

	private int duration;

	private String location;
	private String area;
	private String caption;

	public String getDocumentId() {
		return DocumentId;
	}

	public void setDocumentId(String documentId) {
		DocumentId = documentId;
	}

	public String getCreatedBy() {
		return CreatedBy;
	}

	public void setCreatedBy(String createdBy) {
		CreatedBy = createdBy;
	}

	public String getProjectId() {
		return ProjectId;
	}

	public void setProjectId(String projectId) {
		ProjectId = projectId;
	}

	public String getDocumentType() {
		return DocumentType;
	}

	public void setDocumentType(String documentType) {
		DocumentType = documentType;
	}

	public String getDocumentName() {
		return DocumentName;
	}

	public void setDocumentName(String documentName) {
		DocumentName = documentName;
	}

	public Date getCreatedDate() {
		return CreatedDate;
	}

	public void setCreatedDate(Date createdDate) {
		CreatedDate = createdDate;
	}

	public String getDocumentPath() {
		return DocumentPath;
	}

	public void setDocumentPath(String documentPath) {
		DocumentPath = documentPath;
	}

	public int getVersionId() {
		return VersionId;
	}

	public void setVersionId(int versionId) {
		VersionId = versionId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getDocstyle() {
		return docstyle;
	}

	public void setDocstyle(String docstyle) {
		this.docstyle = docstyle;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public String getCaption() {
		return caption;
	}

	public void setCaption(String caption) {
		this.caption = caption;
	}

}
