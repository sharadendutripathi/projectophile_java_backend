package com.project.backend.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.project.backend.entity.Project;

public interface ProjectRepository extends CrudRepository<Project,String> {

	public List<Project> findByIsPassedByAdmins(boolean flag);

}
