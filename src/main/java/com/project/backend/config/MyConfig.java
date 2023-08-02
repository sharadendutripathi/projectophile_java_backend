package com.project.backend.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.project.backend.twilio_services.SmsService;

@Configuration
@EnableMethodSecurity
public class MyConfig{
	
	

	public MyConfig() {
		// TODO Auto-generated constructor stub
	}
	

	
	
	 @Bean
	 public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
		 return builder.getAuthenticationManager();
	 }
	
	
	
	
//	@Bean
//	public UserDetailsService getUserDetailService() {
//		return new UserDetailsServiceImpl();
//	}
	
	
	
	@Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder(10);
    }
	
	
	
	@Bean
	public SmsService sms_Service() {
		return new SmsService();
	}
	
	
	

}
