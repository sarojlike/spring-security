package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("/")
	public @ResponseBody String welcome() {
		return "Welcome to Spring MVC example with spring-security";
	}
	
	@RequestMapping("/hello")
	public @ResponseBody String hi() {
		return "hello world";
	}
	
	
}
