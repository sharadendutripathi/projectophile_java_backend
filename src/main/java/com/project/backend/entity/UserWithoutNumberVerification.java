/**
 * 
 */
package com.project.backend.entity;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * @author Sharadendu
 *
 */

@Entity
public class UserWithoutNumberVerification {

	/**
	 * 
	 */
	
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

	
	@NotNull
	private LocalDate createdOn;
	
	
	@NotNull
	private String numberOtp;
	
	
	
	
	public String getNumberOtp() {
		return numberOtp;
	}



	public void setNumberOtp(String numberOtp) {
		this.numberOtp = numberOtp;
	}

	
	
	
//Constructors have been initialized down here...============================================================
	
	
	
	public UserWithoutNumberVerification(String number, String email, String password,  LocalDate createdOn) {
		super();
		this.number = number;
		this.email = email;
		this.password = password;
		
		this.createdOn = createdOn;
		
	}	
	
	
	
//TOSTRING METHOD TO MAKE DEBUGGING EASIER================================================================

	
	
	@Override
	public String toString() {
		return "User [number=" + number + ", email=" + email + ", password=" + password + ", createdOn=" + createdOn + "]";
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

	



	public UserWithoutNumberVerification() {
		super();
		// TODO Auto-generated constructor stub
	}



	public LocalDate getCreatedOn() {
		return createdOn;
	}




	public void setCreatedOn(LocalDate createdOn) {
		this.createdOn = createdOn;
	}


	
	

}
