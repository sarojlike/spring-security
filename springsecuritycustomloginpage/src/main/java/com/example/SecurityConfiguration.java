package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/*
 * this is the configuration file for spring security 
 * here user-name and password are mentioned for login into this MVC application
 * and configure method is here to authenticate any http request and stop them if user-name and password is not provided
 */

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	public void configureGlobel(AuthenticationManagerBuilder auth) throws Exception {
		
		auth
		.inMemoryAuthentication()
		.withUser("saroj")
		.password("{noop}123")
		.roles("USER");
		
	}
	
	
	public void configure(HttpSecurity http) throws Exception {
		
		http
		.authorizeRequests()
		.antMatchers("/login")
		.permitAll()
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.loginPage("/login");
		
	}
	
	
}
