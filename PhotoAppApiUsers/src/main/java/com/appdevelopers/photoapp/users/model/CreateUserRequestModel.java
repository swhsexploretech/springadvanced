package com.appdevelopers.photoapp.users.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUserRequestModel {
	
	@NotNull(message = "First Name cannot be null")
	@Size(min = 3, message = "First Name cannot be less than 3 charecters")
	private String firstName;
	
	@NotNull(message = "Last Name cannot be null")
	@Size(min = 3, message = "Last Name cannot be less than 3 charecters")
	private String lastName;
	
	@NotNull(message = "Password cannot be null")
	@Size(min = 3, max=10, message = "Password length should be between 3 and 10 charecters")
	private String password;
	
	@NotNull(message = "Email cannot be null")
	@Email
	private String email;
		
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
	

}
