package com.project.backend.db_services;

import java.util.List;

import com.project.backend.entity.User;

public interface UserService {

	User saveUser(User user);
	
	void deleteUserById(String id);
	
	List<User> fetchAllUser();
	
	User fetchUserById(String id);
	
	User updateUser(User user, String id);

}
