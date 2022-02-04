package com.appdevelopers.photoapp.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.appdevelopers.photoapp.user.shared.UserDTO;

public interface UserService extends UserDetailsService{
	
	UserDTO createUser(UserDTO userDetails);
	UserDTO getUserDetailsByEmail(String email);
	UserDTO getUserByUserID(String userId);
	

}
