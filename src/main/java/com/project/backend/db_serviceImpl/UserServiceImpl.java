package com.project.backend.db_serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.backend.db_services.UserService;
import com.project.backend.entity.User;
import com.project.backend.repositories.UserRepository;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validator;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userRepository;
	
	
	
	//To validate all the fields in the entity class of user to make passwords mail number constrains ============
	private final Validator validator;
	

	@Autowired
	public UserServiceImpl(Validator validator){
		this.validator=validator;
	}
	
	
	
	@Override
	public User fetchUserById(String id) {
	//getting the user from the userRepository and returning it.
		return userRepository.getUserByNumber(id);
	}

	

	

	@Override
	public List<User> fetchAllUser() {
		List<User> list=new ArrayList<>();
		
	//as CrudRepository returns an Iterable Object adding it to the list one by one and returning the list=========
		Iterable<User> it=userRepository.findAll();
		
		for(User u:it) {
			list.add(u);
		}
		
		return list;
	}

	
	@Override
	public User saveUser(User user) {
		
		Set<ConstraintViolation<User>> violations = validator.validate(user);
        if (!violations.isEmpty()) {
            // Handling validation errors here
            for (ConstraintViolation<User> violation : violations) {
                System.out.println(violation.getPropertyPath() + ": " + violation.getMessage());
            }
            // Throw an exception or handle the errors accordingly
        }
		
		userRepository.save(user);
		return user;
		
		
	}

	@Override
	public void deleteUserById(String id) {
		
		userRepository.deleteById(id);
		
	}

	@Override
	public User updateUser(User user, String id) {
		
	//Updating user using userRepository's save method============================================================
		
		System.out.println("Updating User and this line is trigerred from updateUser method of UserServiceImpl class.");
		
		return userRepository.save(user);
	}

}
