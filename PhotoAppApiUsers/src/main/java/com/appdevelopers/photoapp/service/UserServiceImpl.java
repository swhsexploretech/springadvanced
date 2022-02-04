package com.appdevelopers.photoapp.service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.appdevelopers.photoapp.user.shared.UserDTO;
import com.appdevelopers.photoapp.users.data.AlbumsServiceClient;
import com.appdevelopers.photoapp.users.data.UserEntity;
import com.appdevelopers.photoapp.users.model.AlbumResponseModel;
import com.appdevelopers.photoapp.users.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	UserRepository userRepository;

	BCryptPasswordEncoder bCryptPasswordEncoder;

	RestTemplate restTemplate;

	Environment environment;

	AlbumsServiceClient albumServiceClient;
	
	Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

	@Autowired
	public UserServiceImpl(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder, RestTemplate restTemplate
			,Environment environment, AlbumsServiceClient albumServiceClient) {
		this.userRepository=userRepository;
		this.bCryptPasswordEncoder=bCryptPasswordEncoder;
		this.restTemplate=restTemplate;
		this.environment=environment;
		this.albumServiceClient=albumServiceClient;
	}

	@Override
	public UserDTO createUser(UserDTO userDetails) {
		// TODO Auto-generated method stub
		userDetails.setUserId(UUID.randomUUID().toString());
		userDetails.setEncryptedPassword(bCryptPasswordEncoder.encode(userDetails.getPassword()));
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
		UserEntity userEntity = modelMapper.map(userDetails, UserEntity.class);
		//userEntity.setEncryptedPassword("test");
		userRepository.save(userEntity);		
		UserDTO returnValue=modelMapper.map(userEntity, UserDTO.class);
		return returnValue;
	}


	@Override public UserDetails loadUserByUsername(String username) throws
	UsernameNotFoundException { 
		UserEntity user = userRepository.findByEmail(username); 
		if(user == null ) { 
			throw new UsernameNotFoundException(username);
		}		
		return new User(user.getEmail(),user.getEncryptedPassword(),true,true,true,true, new ArrayList<>());

	}


	@Override
	public UserDTO getUserDetailsByEmail(String email) {
		UserEntity user=userRepository.findByEmail(email);
		if(user == null ) throw new UsernameNotFoundException(email);
		return new ModelMapper().map(user, UserDTO.class);
	}

	@Override
	public UserDTO getUserByUserID(String userId) {
		UserEntity user=userRepository.findUserByUserId(userId);
		if(user == null) {
			throw new UsernameNotFoundException(userId);
		}
		UserDTO userDTO= new ModelMapper().map(user, UserDTO.class);
		String baseUrl = environment.getProperty("albums.url");
		String albumsUrl=String.format(baseUrl, userId);

		/*
		 * ResponseEntity<List<AlbumResponseModel>> albumListResponse =
		 * restTemplate.exchange(albumsUrl, HttpMethod.GET, null, new
		 * ParameterizedTypeReference<List<AlbumResponseModel>>(){});
		 */

		/*
		 * 
		 * if(albumListResponse.getBody()!=null) { response =
		 * albumListResponse.getBody(); userDTO.setAlbums(response); }
		 */
		logger.info("Before calling Albums Microservice");
		List<AlbumResponseModel> response = albumServiceClient.getAlbums(userId);
		logger.info("After calling Albums Microservice");
		userDTO.setAlbums(response);
		return userDTO;

	}



}
