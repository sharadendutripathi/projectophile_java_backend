package com.project.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.twilio_services.SmsService;



@RestController
@RequestMapping("/sms")
public class SMSController {
	
	
	@Autowired
	private SmsService sms_Service;
	
	
//It is an api to send messages============================================================
	
	@GetMapping("/send")
	public ResponseEntity<String> sendSMS(@RequestBody String str){
		
		sms_Service.sendSMS("This is an example sms\n\n P- ", "+918561031310");		
		return ResponseEntity.ok("SMS has been sent");
		
	}
	
	
	
//It is an verify api to verify user==========================================================

	/**
    @PostMapping("/verify")
    public ResponseEntity<String> verifyMobileNumber(@RequestBody VerificationRequest request) {
        
    	String mobileNumber = request.getMobileNumber();
        String enteredOtp = request.getOtp();
        
        System.out.println(enteredOtp); 

        String storedOtp = sms_Service.getOtpForMobileNumber(mobileNumber);


        if (enteredOtp.equals(storedOtp)) {
            
            sms_Service.verifyUser(mobileNumber);
            return ResponseEntity.ok("Mobile number verification succeeded.");
        } 
        else {
            
            return ResponseEntity.badRequest().body("Invalid OTP. Mobile number verification failed.");
        }
    	
    }*/
}