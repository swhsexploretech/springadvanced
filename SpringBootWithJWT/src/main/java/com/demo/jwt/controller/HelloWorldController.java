package com.demo.jwt.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
	
	@RequestMapping("/hello")
	public String message() {
		return "Hello Swaroop. Welcome to the Spring JWT integration.";
	}

}
