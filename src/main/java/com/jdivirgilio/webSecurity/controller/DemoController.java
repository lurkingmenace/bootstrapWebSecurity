package com.jdivirgilio.webSecurity.controller;


import java.util.Collection;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DemoController {

	@GetMapping("/")
	public String mainPage(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		// These are strings. Look in SecurityConfig.java
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities(); 
		
		model.addAttribute("userName", user);
		model.addAttribute("authorities", authorities);
		
		return "main";
	}
}
