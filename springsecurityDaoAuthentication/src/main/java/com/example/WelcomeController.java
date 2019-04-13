package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public @ResponseBody String welcome() {
		return "Welcome to Spring security example.";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
}
