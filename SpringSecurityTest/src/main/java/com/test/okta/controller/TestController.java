package com.test.okta.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
	
	@GetMapping("/")
	public String home(@AuthenticationPrincipal OidcUser user) {
		return "Welcome "+user.getFullName();
	}
	
	@GetMapping("/home")
	public String homeMessage(@AuthenticationPrincipal OidcUser user) {
		return "Welcome "+user.getFullName();
	}

}
