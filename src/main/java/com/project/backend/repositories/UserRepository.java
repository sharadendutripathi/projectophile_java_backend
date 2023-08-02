package com.project.backend.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.project.backend.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, String> {

	public User getUserByEmail(String email);
	
	public User getUserByNumber(String number);
	
	@SuppressWarnings("unchecked")
	public User save(User user);

}
