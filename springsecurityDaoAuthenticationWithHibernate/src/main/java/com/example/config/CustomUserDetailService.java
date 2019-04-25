package com.example.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.User.UserBuilder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.entity.User;
import com.example.service.UserService;

@Service
public class CustomUserDetailService implements UserDetailsService{

	@Autowired
	@Qualifier("userService")
	UserService userService;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userService.findUserByLoginName(username);
		UserBuilder builder = org.springframework.security.core.userdetails.User.withUsername(username);
		builder.password(new BCryptPasswordEncoder().encode(user.getPassword()));
		builder.roles(new String [] {});
		return builder.build();
	}

	
}
