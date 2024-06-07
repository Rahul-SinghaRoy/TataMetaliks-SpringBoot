package com.kirat.tm.utils;

import java.util.ArrayList;
import java.util.List;

import com.kirat.tm.model.Tasks;

import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Task;

public class TaskUtil {
	public List<Tasks> getTaskList(ProjectFile project){
		ArrayList<Tasks> taskList=new ArrayList<Tasks>();
		for (Task task : project.getAllTasks())
		{
			Tasks tasks=new Tasks();
			tasks.setTaskid(task.getUniqueID());
			tasks.setTaskname(task.getName());
			taskList.add(tasks);
		}
		return taskList;
	}
	public List<Tasks> getChildTaskList(ProjectFile project){
		ArrayList<Tasks> taskList=new ArrayList<Tasks>();
		for (Task task : project.getAllTasks())
		{
			Tasks tasks=new Tasks();
			tasks.setTaskid(task.getUniqueID());
			tasks.setTaskname(task.getName());
			taskList.add(tasks);
		}
		return taskList;
	}
}
