/**
 * 
 */
package com.project.backend.repositories;

import org.springframework.data.repository.CrudRepository;

import com.project.backend.entity.UserWithoutNumberVerification;

/**
 * @author Sharadendu
 *
 */
public interface UserWithoutNumberVerificationRepository extends CrudRepository<UserWithoutNumberVerification ,String> {

	/**
	 * 
	 */

}
