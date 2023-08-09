package com.project.backend.controller;




import java.time.LocalDate;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.db_services.NumberVerificationService;
import com.project.backend.db_services.UserService;
import com.project.backend.entity.User;
import com.project.backend.entity.UserWithoutNumberVerification;
import com.project.backend.models.JwtRequest;
import com.project.backend.models.JwtResponse;
import com.project.backend.models.NumberOtpRequest;
import com.project.backend.security.JwtHelper;
import com.project.backend.twilio_services.SmsService;

@RestController
@RequestMapping("/signup")
public class AuthController {
	
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	@Autowired
	private AuthenticationManager manager;
	
	@Autowired
	private JwtHelper helper;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private NumberVerificationService numberVerificationService;
	
	@Autowired
	private SmsService smsService;
	
//private Logger logger = LoggerFactory.getLogger(AuthController.class);
	

	
/*==============================================================================================
 * 
 * 
 * 
 * This is the method to authenticate and return the jwt token in response for the user.......
 * 
 * 
 * 
 * ============================================================================================== 
 * */
	
	
	@PostMapping("/login")
    public ResponseEntity<JwtResponse> login(@RequestBody JwtRequest request) {

        this.doAuthenticate(request.getNumber(), request.getPassword());
        

        UserDetails userDetails = userDetailsService.loadUserByUsername(request.getNumber());
        
        System.out.println(userDetails.getUsername()+"=============="+userDetails.getPassword());
        
        String token = this.helper.generateToken(userDetails);
        
        System.out.println("token is"+token);

        JwtResponse response = new JwtResponse(token, userDetails.getUsername());
        		
        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    private void doAuthenticate(String number, String password) {

        UsernamePasswordAuthenticationToken authentication = new UsernamePasswordAuthenticationToken(number, password);
        try {
            manager.authenticate(authentication);


        } catch (BadCredentialsException e) {
            throw new BadCredentialsException(" Invalid Username or Password  !!");
        }

    }

    @ExceptionHandler(BadCredentialsException.class)
    public String exceptionHandler() {
        return "Credentials Invalid !!";
    }
	
	
	
	
		
	
	
	
	
	
	
	
/**  
 * 
 * ====THE FOLLOWING METHOD WAS CREATED TO REGISTER 2 ADMIN ACOUNTS WHICH ARE THE ONLY ADMINS AND HAVE SUPIRIOR RIGHTS ON THE PROJECT==
	--AS THEY HAVE BEEN CREATED NOW THIS SECTION HAS BEEN COMENTED SO THAT NO ONE CAN USE IT TO CREATE AN ADMIN====
	
	*/
    
    
	
	@PostMapping("/createAdmin")
    public ResponseEntity<String> createAdmin (@RequestBody User user) {
        try {
        	
            
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setUserRole("ADMIN");
            user.setEmailVerified(true);
            user.setExpire(false);
            user.setCreatedOn(LocalDate.now());
            user.setResetToken("nonxlkwknsxlwkso");
            
            System.out.println(user);
            User savedUser = userService.saveUser(user);
            return ResponseEntity.ok("ADMIN User saved with ID: " + savedUser.getNumber());
            
        } 
        catch (Exception e) {
        	System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving student user");
        }
    }
	
	
	
/**	
*/
    
    
	
	@PostMapping("/student")
    public ResponseEntity<String> createStudent(@RequestBody UserWithoutNumberVerification user) {
        try {
        	
            
            user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            
            user.setCreatedOn(LocalDate.now());
            //user.setResetToken(RandomStringUtils.randomAlphanumeric(16));
            String otp=smsService.getSixDigitOtp();
            user.setNumberOtp(otp);
            smsService.sendSMS("This is your otp for registration to projectophile"+otp, "+91"+user.getNumber());
            UserWithoutNumberVerification savedUser = numberVerificationService.saveNumberVerification(user);
            return ResponseEntity.ok("User saved with ID: " + savedUser.getNumber());
            
        } 
        catch (Exception e) {
        	System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving student user");
        }
    }
	
	
	
	
	@PostMapping("/verify")
    public ResponseEntity<String> createStudent(@RequestBody NumberOtpRequest req) {
        try {
        	UserWithoutNumberVerification userTV=numberVerificationService.fetchNumberVerificationById(req.getNumber());
            
        	if(userTV.getNumberOtp().equals(req.getOtp())) {
        	
	        	User user= new User(userTV.getNumber(), userTV.getEmail(), userTV.getPassword(), null, "STUDENT", null, false, false);
	            //user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	            //user.setUserRole("STUDENT");
	            user.setEmailVerified(false);
	            user.setExpire(false);
	            user.setCreatedOn(LocalDate.now());
	            user.setResetToken(RandomStringUtils.randomAlphanumeric(16));
	            //user.setNumberOtp(smsService.getSixDigitOtp());
	            //UserWithoutNumberVerification savedUser = numberVerificationService.saveNumberVerification(user);
	            User savedUser=userService.saveUser(user);
	            numberVerificationService.deleteNumberVerificationById(user.getNumber());
	            return ResponseEntity.ok("User saved with ID: " + savedUser.getNumber());
	            
        	}
        	else {
        		return ResponseEntity.ok("Wrong OTP please try again....");
        	}
        	
        } 
        catch (Exception e) {
        	System.out.println(e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving student user");
        }
    }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@GetMapping("/getOtp")
	public ResponseEntity<String> forgotPasswordGetOtp(String usernumber){
		
		return ResponseEntity.ok("Testing lord");
	}
	
	
	
	
	
	@GetMapping("/home")
	public ResponseEntity<String> normalUser(){

		return ResponseEntity.ok("I am under development and created to return data required to show people haven't logged in yet..");
		
	}

}
