package com.project.backend.controller;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.backend.db_services.ProjectService;
import com.project.backend.db_services.UserService;
import com.project.backend.entity.Project;
import com.project.backend.twilio_services.SmsService;


@RestController
@RequestMapping("/mentor")
public class MentorController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	SmsService smsService;

	
	
//This method is a trial to test the autherization and authentication for the MENTOR user group..
	
	@GetMapping("/test")
	public ResponseEntity<String> testPage(){
		
		System.out.println("testing");
		
		return ResponseEntity.ok("testing");
	}
	
	
// This method is to show the basic things to mentors when they log in for the first time.
	
	@GetMapping("/home")
	public ResponseEntity<String> homePage(@AuthenticationPrincipal UserDetails userDetails){
		
		System.out.println(userDetails.getUsername());
		
		return ResponseEntity.ok(userDetails.getUsername());
		
	}
	
	
	
	
//This method is to add a Project By mentors which will further aproved by admins to be shown to the students.
	
	@PostMapping("/addProject")
	public ResponseEntity<Project> createProject(Project project){
		
		project.setPassedByAdmins(false);
		project.setCreatedOn(LocalDate.now());
		Project savedProject=projectService.saveProject(project);
		return ResponseEntity.ok(savedProject);
	}

}
