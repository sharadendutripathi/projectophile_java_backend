package com.project.backend.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.backend.entity.User;
import com.project.backend.repositories.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private UserRepository userRepository;

	public UserDetailsServiceImpl()  {
		// TODO Auto-generated constructor stub
	}

	@Override
	public UserDetails loadUserByUsername(String usernumber) throws UsernameNotFoundException {
		
		User user =userRepository.getUserByNumber(usernumber);
		if(user==null) throw new UsernameNotFoundException("Could Not found user.");
		CustomUserDetails customUserDetails=new CustomUserDetails(user);
		System.out.println("===============================================================");
		System.out.println(customUserDetails.getUsername());
		System.out.println("===============================================================");
		return customUserDetails;
		 
	}

}
