/**
 * 
 */
package com.project.backend.models;

/**
 * @author Sharadendu
 *
 */

public class JwtRequest {

	/**
	 * 
	 */
	private String number;
	
	private String password;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public JwtRequest(String number, String password) {
		super();
		this.number = number;
		this.password = password;
	}

	public JwtRequest() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "JwtRequest [email=" + number + ", password=" + password + "]";
	}
	
	

}
