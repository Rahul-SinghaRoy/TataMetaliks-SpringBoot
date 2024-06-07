package com.kirat.tm.model;
public class TaskTable {
private String TaskId;
private String TaskDetails;
private String Status;
private String CreatedOn;
private String Action;
private String ProjectId;
private String ParentTaskId;
public String getTaskId() {
	return TaskId;
}
public void setTaskId(String taskId) {
	TaskId = taskId;
}
public String getTaskDetails() {
	return TaskDetails;
}
public void setTaskDetails(String taskDetails) {
	TaskDetails = taskDetails;
}
public String getStatus() {
	return Status;
}
public void setStatus(String status) {
	Status = status;
}
public String getCreatedOn() {
	return CreatedOn;
}
public void setCreatedOn(String createdOn) {
	CreatedOn = createdOn;
}
public String getAction() {
	return Action;
}
public void setAction(String action) {
	Action = action;
}
public String getProjectId() {
	return ProjectId;
}
public void setProjectId(String projectId) {
	ProjectId = projectId;
}
public String getParentTaskId() {
	return ParentTaskId;
}
public void setParentTaskId(String parentTaskId) {
	ParentTaskId = parentTaskId;
}



}
