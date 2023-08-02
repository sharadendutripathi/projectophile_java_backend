package com.project.backend.entity;


import java.time.LocalDate;
import java.util.ArrayList;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToMany;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class UserDetail {

	
	
	
//VARIABLE FIELDS HAVE BEEN INITIALIZED DOWN HERE=============================================================
	
	@Id
	@NotNull
	@Size(min=10,max=10)
	@Pattern(regexp = "\\d{10}", message = "Invalid mobile number")
	private String number;
	
	@NotNull
	@Column(unique=true)
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email")
	private String email;
	

	@NotNull
	private String institute;
	
	@NotNull
	private String dob;
	
	@NotNull
	private String userRole;
	
	
	@NotNull
	private LocalDate createdOn;
	
	
	
	
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "project_id")
	private ArrayList<Project> projects;
	
	
	
	
	
//Constructors have been initialized down here...============================================================
	
	
	
	
	public UserDetail(String number, String email, String userRole) {
		super();
		this.number=number;
		this.email = email;
		this.userRole = userRole;
	}
	
	
	
	
//GETTERS AND SETTER ARE BEEN DECLARED DOWN HERE ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	
	
	
	public String getNumber() {
		return number;
	}


	public String getInstitute() {
		return institute;
	}




	public void setInstitute(String institute) {
		this.institute = institute;
	}




	public String getDob() {
		return dob;
	}




	public void setDob(String dob) {
		this.dob = dob;
	}




	public void setNumber(String number) {
		this.number = number;
	}

	
	
	
	public String getUserRole() {
		return userRole;
	}


	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}



	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	
	
	public ArrayList<Project> getProjects() {
		return projects;
	}




	public void setProjects(ArrayList<Project> projects) {
		this.projects = projects;
	}



	
	
	
//TOSTRING METHOD TO MAKE DEBUGGING EASIER================================================================

	


	@Override
	public String toString() {
		return "User [email=" + email +"number=" + number +", password=" + ", user_Role=" + userRole + ", expireDate="
				+ "]";
	}
	
	

}
