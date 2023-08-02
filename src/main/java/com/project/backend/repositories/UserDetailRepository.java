package com.project.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.backend.entity.UserDetail;

public interface UserDetailRepository extends CrudRepository<UserDetail, String> {

}
