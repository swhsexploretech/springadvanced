package com.photoapp.zuul.apigateway.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

@Configuration
@EnableWebSecurity
public class WebSecurity extends WebSecurityConfigurerAdapter{
	
	private Environment environment;
	
	
	@Autowired
	public WebSecurity(Environment environment) {
		super();
		this.environment = environment;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		//The below is required else it will not allow to open the built in frameworks like h2 console and all.
		//Adding the below configuration allows to access those consoles. 
		http.headers().frameOptions().disable();
		
		http.authorizeRequests().
		antMatchers(environment.getProperty("api.actuator.url.path")).permitAll().
		antMatchers(environment.getProperty("api.users.actuator.url.path")).permitAll().
		antMatchers(HttpMethod.POST, environment.getProperty("api.login.url.path")).permitAll().
		antMatchers(HttpMethod.POST, environment.getProperty("api.registration.url.path")).permitAll().
		antMatchers(HttpMethod.POST, environment.getProperty("api.h2console.url.path")).permitAll().
	
		anyRequest().authenticated()
		.and().addFilter(new AuthorizationFilter(authenticationManager(), environment));
		//Making Rest API stateless.
		//This will make the application stateless. When this application is accessed by multiple clients there
		//are chances that the information like the jwt token and the userid may be cached in the http headers and 
		// to prevent that the session is specifically set to stateless so that it wont cache any such information.
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}

}
