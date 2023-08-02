package com.project.backend.db_serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.backend.entity.UserWithoutNumberVerification;
import com.project.backend.repositories.UserWithoutNumberVerificationRepository;
import com.project.backend.db_services.NumberVerificationService;
import com.project.backend.entity.User;

@Service
public class NumberVerificationServiceImpl implements NumberVerificationService{

	@Autowired
	UserWithoutNumberVerificationRepository userWithoutNumberVerificationRepository;

	@Override
	public UserWithoutNumberVerification saveNumberVerification(UserWithoutNumberVerification userWithoutNumberVerification) {
		return userWithoutNumberVerificationRepository.save(userWithoutNumberVerification);
		
	}

	@Override
	public void deleteNumberVerificationById(String id) {
		userWithoutNumberVerificationRepository.deleteById(id);
		
	}

	@Override
	public List<User> fetchAllNumberVerification() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public UserWithoutNumberVerification fetchNumberVerificationById(String id) {
		return userWithoutNumberVerificationRepository.findById(id).get();
		
	}

	@Override
	public UserWithoutNumberVerification updateNumberVerification(UserWithoutNumberVerification user, String id) {
		// TODO Auto-generated method stub
		return null;
	}

}
