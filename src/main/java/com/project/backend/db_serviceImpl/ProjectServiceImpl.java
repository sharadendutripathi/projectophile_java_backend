/**
 * 
 */
package com.project.backend.db_serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.backend.db_services.ProjectService;
import com.project.backend.entity.Project;
import com.project.backend.repositories.ProjectRepository;

/**
 * @author Sharadendu
 *
 */
@Service
public class ProjectServiceImpl implements ProjectService {

	/**
	 * 
	 */
	public ProjectServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	
	@Autowired
	ProjectRepository projectRepository;
	
	
	
	@Override
	public Project saveProject(Project project) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteProjectById(String id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Project> fetchAllProject() {
		
		Iterable<Project> it= projectRepository.findAll();
		List<Project> arr= new ArrayList<Project>();
		it.forEach(arr::add);
		
		
		return arr;
	}

	@Override
	public Project fetchProjectById(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	
	@Override
	public List<Project> fetchProjectWhichArePassedByAdmin() {
		
		return projectRepository.findByIsPassedByAdmins(true);
	}

	@Override
	public List<Project> fetchProjectWhichAreNotPassedByAdmin() {
		return projectRepository.findByIsPassedByAdmins(false);
	}

	@Override
	public Project updateProject(Project project, String id) {
		return null;
	}

	

	
	
}
