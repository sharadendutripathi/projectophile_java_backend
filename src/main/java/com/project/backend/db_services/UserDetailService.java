package com.project.backend.db_services;

import java.util.List;

import com.project.backend.entity.User;
import com.project.backend.entity.UserDetail;

public interface UserDetailService {
	
	
	UserDetail saveUserDetail(User user);
	
	void deleteUserDetailById(String id);
	
	List<UserDetail> fetchAllUserDetail();
	
	UserDetail fetchUserDetailById(String id);
	
	UserDetail updateUserDetail(User user, String id);
}
