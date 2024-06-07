package com.kirat.tm.utils;

import java.util.Comparator;

import com.kirat.tm.model.TaskTarget;

class SortBySerial implements Comparator<TaskTarget> 
{ 
    // Used for sorting in ascending order of 
    // roll number 
    public int compare(TaskTarget a, TaskTarget b) 
    { 
        return a.getSerial() - b.getSerial(); 
    } 
} 
