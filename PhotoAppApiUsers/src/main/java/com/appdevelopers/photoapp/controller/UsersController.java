package com.appdevelopers.photoapp.controller;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.appdevelopers.photoapp.service.UserService;
import com.appdevelopers.photoapp.user.shared.UserDTO;
import com.appdevelopers.photoapp.users.model.CreateUserRequestModel;
import com.appdevelopers.photoapp.users.model.CreateUserResponseModel;
import com.appdevelopers.photoapp.users.model.UserResponseModel;


@RestController
@RequestMapping("/users")
public class UsersController {
	
	@Autowired
	private Environment environment;
	
	@Autowired
	UserService userService;
	
	@GetMapping("/status/check")
	public String status() {
		return "working on port number"+environment.getProperty("local.server.port")+" and the token value is "+environment.getProperty("token.secret");
	}

	@PostMapping(
			consumes = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE},
			produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE}
	)
	public ResponseEntity<CreateUserResponseModel> createUser(@Valid @RequestBody CreateUserRequestModel userDetails) {
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserDTO userDTO = modelMapper.map(userDetails, UserDTO.class);
		UserDTO createdUser = userService.createUser(userDTO);
		CreateUserResponseModel returnValue = modelMapper.map(createdUser, CreateUserResponseModel.class);
		return new ResponseEntity<CreateUserResponseModel>(returnValue, HttpStatus.CREATED);		
	}
	
	@GetMapping(value = "/{userId}" , produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<UserResponseModel> getUser(@PathVariable("userId") String userId){		
		UserDTO userDTO = userService.getUserByUserID(userId);
		UserResponseModel returnValue = new ModelMapper().map(userDTO, UserResponseModel.class);
		return ResponseEntity.status(HttpStatus.OK).body(returnValue);
	}
}
