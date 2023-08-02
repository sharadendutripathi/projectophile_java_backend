/**
 * 
 */
package com.project.backend.db_services;

import java.util.List;

import com.project.backend.entity.Project;

/**
 * @author Sharadendu
 *
 */
public interface ProjectService {
	
	Project saveProject(Project project);
	
	void deleteProjectById(String id);
	
	List<Project> fetchAllProject();
	
	List<Project> fetchProjectWhichArePassedByAdmin();
	
	List<Project> fetchProjectWhichAreNotPassedByAdmin();
	
	Project fetchProjectById(String id);
	
	Project updateProject(Project project, String id);

}
