package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/*
 * this is the configuration file for spring security 
 * here user-name and password are mentioned for login into this MVC application
 * and configure method is here to authenticate any http request and stop them if user-name and password is not provided
 */

@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Autowired
	private CustomUserDetailService customUserDetailService;
	
	
	/*
	 * @Autowired public void configureGlobel(AuthenticationManagerBuilder auth)
	 * throws Exception { DaoAuthenticationProvider authProvider = new
	 * DaoAuthenticationProvider();
	 * authProvider.setUserDetailsService(customUserDetailService);
	 * authProvider.setPasswordEncoder(new BCryptPasswordEncoder());
	 * auth.authenticationProvider(authProvider); }
	 */
	 
	
	
	  @Autowired public void configureGlobel(AuthenticationManagerBuilder auth)
	  throws Exception {
	  
	  auth .inMemoryAuthentication() .withUser("saroj") .password("{noop}123")
	  .roles("USER");
	  
	  }
	 
	public void configure(HttpSecurity http) throws Exception {
		
		AuthenticationSuccessHandler successHandler= new SucessHandler();
		
			http
			.authorizeRequests()
			.antMatchers("/login")
			.permitAll()
			.anyRequest()
			.authenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.successHandler(successHandler)
			.and()
			.rememberMe()
			.key("rem-me")
			//.userDetailsService(customUserDetailService)
			.rememberMeParameter("rememberme")
			.rememberMeCookieName("rememberlogin")
			.tokenValiditySeconds(10000)
			.and()
			.logout()
			.deleteCookies("JSESSIONID")
			.logoutSuccessUrl("/login?logout=true")
			.invalidateHttpSession(true);
		
	}
	
	
}
