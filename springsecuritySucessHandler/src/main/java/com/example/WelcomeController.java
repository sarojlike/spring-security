package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class WelcomeController {

	@RequestMapping("/welcome")
	public  String welcome(Model model) {
		model.addAttribute("welcomeMessage", "welcome user you are now logged in");
		return "welcome";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "login";
	}
	
	
}
