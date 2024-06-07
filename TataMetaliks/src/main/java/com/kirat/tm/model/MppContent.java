package com.kirat.tm.model;

public class MppContent {
private String TaskName;
private String Duration;
private String Start;
private String Finish;
private String ActualStart;
private String ActualFinish;
private String TotalSlack;
private String PercentageWork;
public String getTaskName() {
	return TaskName;
}
public void setTaskName(String taskName) {
	TaskName = taskName;
}
public String getDuration() {
	return Duration;
}
public void setDuration(String duration) {
	Duration = duration;
}
public String getStart() {
	return Start;
}
public void setStart(String start) {
	Start = start;
}
public String getFinish() {
	return Finish;
}
public void setFinish(String finish) {
	Finish = finish;
}
public String getActualStart() {
	return ActualStart;
}
public void setActualStart(String actualStart) {
	ActualStart = actualStart;
}
public String getActualFinish() {
	return ActualFinish;
}
public void setActualFinish(String actualFinish) {
	ActualFinish = actualFinish;
}
public String getTotalSlack() {
	return TotalSlack;
}
public void setTotalSlack(String totalSlack) {
	TotalSlack = totalSlack;
}
public String getPercentageWork() {
	return PercentageWork;
}
public void setPercentageWork(String percentageWork) {
	PercentageWork = percentageWork;
}

}
