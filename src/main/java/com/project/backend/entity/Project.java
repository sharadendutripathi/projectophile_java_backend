package com.project.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.NotNull;


@Entity
public class Project {

	
	
	@Id
	private String projectId;

	@NotNull
	private String projectName;
	
	private String projectImageLink;
	
	@NotNull
	private String projectMentor;
	
	@NotNull
	private LocalDate createdOn;
	
	@NotNull
	private String subject;
	
	@NotNull
	private String topic;
	
	@NotNull
	private String projectDescription;

	@NotNull
	private boolean isPassedByAdmins;
	
	@ManyToOne
	UserDetail userDetail;
	
	
	
//Generating getters and setters here==============================================================

	public boolean isPassedByAdmins() {
		return isPassedByAdmins;
	}

	public void setPassedByAdmins(boolean isPassedByAdmins) {
		this.isPassedByAdmins = isPassedByAdmins;
	}

	

	public UserDetail getUserDetail() {
		return userDetail;
	}

	public void setUserDetail(UserDetail userDetail) {
		this.userDetail = userDetail;
	}

	
	public String getProjectId() {
		return projectId;
	}

	public void setProjectId(String projectId) {
		this.projectId = projectId;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectImageLink() {
		return projectImageLink;
	}

	public void setProjectImageLink(String projectImageLink) {
		this.projectImageLink = projectImageLink;
	}

	public String getProjectMentor() {
		return projectMentor;
	}

	public void setProjectMentor(String projectMentor) {
		this.projectMentor = projectMentor;
	}

	public LocalDate getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}

	public String getProjectDescription() {
		return projectDescription;
	}

	public void setProjectDescription(String projectDescription) {
		this.projectDescription = projectDescription;
	}
	
	
	
	
//Constructors using Fields is defined down here=========================================
	
	
	public Project(String projectId, @NotNull String projectName, String projectImageLink, @NotNull String projectMentor,
			@NotNull LocalDate createdOn, @NotNull String projectDescription, boolean isPassedByAdmins,
			UserDetail userDetail) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.projectImageLink = projectImageLink;
		this.projectMentor = projectMentor;
		this.createdOn = createdOn;
		this.projectDescription = projectDescription;
		this.isPassedByAdmins = isPassedByAdmins;
		this.userDetail = userDetail;
	}
	
	
	
	
	
	
//Constructor from SuperClass is defined bellow=========================================
	


	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	
	
	
	

}
