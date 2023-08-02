package com.project.backend.twilio_services;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;

@Service
public class SmsService {

	public SmsService() {
		// TODO Auto-generated constructor stub
	}
	
	private String account_Sid="ACa160707929b758186e8c3645a207e5ca";
	private String auth_Token="f48e567b1d462d4d931f88eec4b4f6c6";
	
	


	
	public void sendSMS(String sms, String number) {
		
		Twilio.init(account_Sid, auth_Token);
        Message message = Message.creator(
                new com.twilio.type.PhoneNumber(number),
                new com.twilio.type.PhoneNumber("+15416232726"),
                sms)
            .create();

        System.out.println(message.getSid());
	}
	
	
	
	public String getSixDigitOtp(){
		
		
        String sixRandomNumber = RandomStringUtils.randomNumeric(6);
        System.out.println(sixRandomNumber);
        return sixRandomNumber;
		
	}
	
	
	public String verifyUser(String mobilenumber) {
		return null;
	}

}
