/**
 * 
 */
package com.project.backend.db_services;

import java.util.List;

import com.project.backend.entity.UserWithoutNumberVerification;
import com.project.backend.entity.User;

/**
 * @author Sharadendu
 *
 */
public interface NumberVerificationService {
	
	UserWithoutNumberVerification saveNumberVerification(UserWithoutNumberVerification userWithoutNumberVerification);
	
	void deleteNumberVerificationById(String id);
	
	List<User> fetchAllNumberVerification();
	
	UserWithoutNumberVerification fetchNumberVerificationById(String id);
	
	UserWithoutNumberVerification updateNumberVerification(UserWithoutNumberVerification user, String id);

}
