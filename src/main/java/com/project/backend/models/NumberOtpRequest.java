/**
 * 
 */
package com.project.backend.models;

/**
 * @author Sharadendu
 *
 */
public class NumberOtpRequest {

	/**
	 * 
	 */
	private String number;
	
	public NumberOtpRequest(String number, String otp) {
		super();
		this.number = number;
		this.otp = otp;
	}

	private String otp;

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

}
