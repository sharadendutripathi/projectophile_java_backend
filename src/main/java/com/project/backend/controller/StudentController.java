package com.project.backend.controller;

import com.project.backend.entity.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/student")
public class StudentController {
	
	@Autowired
	
	

	public StudentController() {
		// TODO Auto-generated constructor stub
	}
	
	//This method was created to send data of the users from the backend to display home page.
	
	@GetMapping("/home")
	public ResponseEntity<String> homePage(){
		
		return ResponseEntity.ok("I was created to return essential and first information about any student when he logged in. ");
	}
	
	
	//This method is to return all the projects which are passed by admins.
	
	@GetMapping("/allProjectsList")
	public List<Project> allProjectList(){
		return null;
	}
	
	
	//This method is to return all the purchased project by the student.......
	@GetMapping("/purchasedProject")
	public List<Project> purchasedProject(){
		return null;
	}
	
	
	
	
	
	
	

}
