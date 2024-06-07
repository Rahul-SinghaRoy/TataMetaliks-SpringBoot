package com.kirat.tm.utils;

import java.util.ArrayList;
import java.util.List;

import com.kirat.tm.model.Resources;

import net.sf.mpxj.ProjectFile;
import net.sf.mpxj.Resource;

public class ResourceUtil {
public List<Resources> getResourceList(ProjectFile project){
	ArrayList<Resources> resourceList=new ArrayList<Resources>();
	for (Resource resource : project.getAllResources())
	{
		Resources resources=new Resources();
		resources.setResourceid(resource.getUniqueID());
		resources.setResourcename(resource.getName());
		resourceList.add(resources);
	}
	return resourceList;
}
}
