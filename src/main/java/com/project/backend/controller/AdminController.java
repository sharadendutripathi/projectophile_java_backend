package com.project.backend.controller;

import java.time.LocalDate;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.db_services.ProjectService;
import com.project.backend.db_services.UserDetailService;
import com.project.backend.db_services.UserService;
import com.project.backend.entity.Project;
import com.project.backend.entity.User;
import com.project.backend.entity.UserDetail;
import com.project.backend.twilio_services.SmsService;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	UserDetailService userDetailService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	SmsService smsService;
	
	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;

	
	
//Api to register a MENTOR which can only be created by ADMIN================================================
	
	
	@PostMapping("/creatementor")
    public ResponseEntity<String> createMentor(@RequestBody User user) {
        try {            
        	user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
            user.setUserRole("MENTOR");
            user.setEmailVerified(true);
            user.setExpire(false);
            user.setCreatedOn(LocalDate.now());
            user.setResetToken(RandomStringUtils.randomAlphanumeric(16));
            User savedUser = userService.saveUser(user);
            
            return informMentor(savedUser);
        }
        
        catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error saving teacher user");
            
        }
    }
	
	
	
	
	
// Get mapping to pass a project which can be displayed..========================================
	
	
	@GetMapping("/passProject/{id}")
	public ResponseEntity<String> passProject(@PathVariable String id){
		
		try {
			Project passedProject=projectService.fetchProjectById(id);
			
			if(passedProject!=null) {
				passedProject.setPassedByAdmins(true);
				projectService.saveProject(passedProject);
				return ResponseEntity.ok("The project with id #"+id+" has been updated successfully.");
			}
			
			else return ResponseEntity.ok("Couldn't find the project with the given id.");
			
		}
		
		catch(Exception e) {
			return ResponseEntity.internalServerError().body("Something went wrong.");
		}
		
	}
	
	
	
	
	
//Get method to delete a project ========================================================
	
	
	
	@GetMapping("/deleteProject/{id}")
	public ResponseEntity<String> deleteProject(@PathVariable String id){
		try {
			projectService.deleteProjectById(id);
			
			return ResponseEntity.ok("Couldn't find the project with the given id.");
		}
		catch(Exception e) {
			return ResponseEntity.internalServerError().body("Some Error occured while deleting the Project.");
		}
		
	}
	
	
	
	
	
//Methods down bellow are for ease and will be removed in future================================
	
	@DeleteMapping("/deleteStudent")
	public boolean deleteStudent(String email) {
		return false;
	}
	
	@GetMapping("/getUsers")
	public List<User> getUsers(){
		return (userService.fetchAllUser());
	}
	
	@GetMapping("/getProjects")
	public ResponseEntity<List<Project>> getProjects(){
		return ResponseEntity.ok(projectService.fetchAllProject());
	}
	
	@GetMapping("/getUserDetail")
	public List<UserDetail> getUserDetail(){
		return userDetailService.fetchAllUserDetail();
	}

	
	
/**
 * 
 */
	
	private ResponseEntity<String> informMentor(User user){
		try {
        	
        	smsService.sendSMS("Hi Mentor You have been Registered as the MENTOR at Projectophile by ADMINS. \n\n  Wishes and Regards.", "+91"+user.getNumber());
        	return ResponseEntity.ok("Mentor with mentor id "+user.getNumber()+" has been saved Succesfully and SMS on his number is sent succesfully.");
        }catch(Exception e) {
        	return ResponseEntity.ok("Mentor with mentor id "+user.getNumber()+" has been saved Succesfully but the SMS to inform him is failed to send.");
        }
	}
	
	
}
