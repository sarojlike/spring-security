package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

/*
 * this is the configuration file for spring security 
 * here user-name and password are mentioned for login into this MVC application
 */

@EnableWebSecurity
public class SecurityConfiguration {

	@Autowired
	public void configureGlobel(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("saroj").password("{noop}123").roles("USER");
	}
	
}
