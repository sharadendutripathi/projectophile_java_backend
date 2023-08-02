package com.project.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Entity
public class User {

	
	
	
//VARIABLE FIELDS HAVE BEEN INITIALIZED DOWN HERE=============================================================
	
	@Id
	@NotNull
	@Size(min=10,max=10)
	@Pattern(regexp = "\\d{10}", message = "Invalid mobile number")
	private String number;
	
	@NotNull
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@(.+)$", message = "Invalid email")
	private String email;
	
	@NotNull
	@Size(min=8)
	private String password;
	
	
	@Size(min=8)
	private String resetToken;
	
	@NotNull
	private String userRole;
	
	@NotNull
	private LocalDate createdOn;
	
	
	
	
	@NotNull
	private boolean isExpire;
	
	@NotNull
	private boolean isEmailVerified;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = false)
	@JoinColumn(name="number")
	private UserDetail userDetail;
	
	
	
	
//Constructors have been initialized down here...============================================================
	
	
	
	public User(String number, String email, String password, String resetToken, String userRole, LocalDate createdOn, boolean isExpire, boolean isEmailVerified) {
		super();
		this.number = number;
		this.email = email;
		this.password = password;
		this.resetToken = resetToken;
		this.userRole = userRole;
		this.createdOn = createdOn;
		this.isExpire = isExpire;
		this.isEmailVerified = isEmailVerified;
	}	
	
	
	
//TOSTRING METHOD TO MAKE DEBUGGING EASIER================================================================

	
	
	@Override
	public String toString() {
		return "User [number=" + number + ", email=" + email + ", password=" + password + ", resetToken=" + resetToken
				+ ", userRole=" + userRole + ", createdOn=" + createdOn + ", isExpire=" + isExpire
				+ ", isEmailVerified=" + isEmailVerified + "]";
	}

	
	
	
	
//GETTERS AND SETTER ARE BEEN DECLARED DOWN HERE ++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
	
	


	public String getNumber() {
		return number;
	}




	public void setNumber(String number) {
		this.number = number;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getResetToken() {
		return resetToken;
	}




	public void setResetToken(String resetToken) {
		this.resetToken = resetToken;
	}




	public String getUserRole() {
		return userRole;
	}




	public void setUserRole(String userRole) {
		this.userRole = userRole;
	}




	public LocalDate getCreatedOn() {
		return createdOn;
	}




	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}




	public boolean isExpire() {
		return isExpire;
	}




	public void setExpire(boolean isExpire) {
		this.isExpire = isExpire;
	}




	public boolean isEmailVerified() {
		return isEmailVerified;
	}




	public User() {
		super();
		// TODO Auto-generated constructor stub
	}



	public void setEmailVerified(boolean isEmailVerified) {
		this.isEmailVerified = isEmailVerified;
	}

	
	
	

}
