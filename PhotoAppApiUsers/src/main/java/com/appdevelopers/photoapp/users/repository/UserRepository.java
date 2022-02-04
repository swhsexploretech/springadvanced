package com.appdevelopers.photoapp.users.repository;

import org.springframework.data.repository.CrudRepository;

import com.appdevelopers.photoapp.users.data.UserEntity;

public interface UserRepository extends CrudRepository<UserEntity, Long> {
	
	UserEntity findByEmail(String email);
	UserEntity findUserByUserId(String userId);

}
