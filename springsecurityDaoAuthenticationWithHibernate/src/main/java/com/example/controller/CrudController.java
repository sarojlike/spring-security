package com.example.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.entity.User;
import com.example.service.UserService;

@Controller
public class CrudController {

	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@ModelAttribute
	public User initilizeUser() {
		return new User();
	}
	
	@RequestMapping("/")
	public  String openCreteUser() {
		return "createuser";
	}
	
	@RequestMapping(value = {"/createUser"}, method = {RequestMethod.GET,RequestMethod.POST})
	public String createNewUser(@ModelAttribute("user") User user,Model model) {
		long uid = userService.createUser(user);
		if(uid>0) {
			model.addAttribute("message", "Thanks for Registration");
		}
		return "welcome";
	}
	
	
	  @RequestMapping("/login") 
	  public String login() { 
		  return "login"; 
		  
	  }
	 
	  
	  @RequestMapping("/welcome")
		public  String welcome(Model model) {
			model.addAttribute("welcomeMessage", "welcome user you are now logged in");
			return "welcomeLoginUser";
		}
		
		
		
		@RequestMapping("/logout")
		public String logout(HttpServletRequest request,HttpServletResponse response) {
			
			Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
			
			if(authentication !=null) {
				new SecurityContextLogoutHandler().logout(request, response, authentication);
			}
				
			return "redirect:/login?logout=true";
		}

	
	
}
