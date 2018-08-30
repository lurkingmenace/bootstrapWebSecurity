package com.jdivirgilio.webSecurity.controller;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
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

		for (Object o : authorities) {
			if (((SimpleGrantedAuthority)o).getAuthority().equals("ROLE_MANAGER") )
				model.addAttribute("isManager", true);
			if (((SimpleGrantedAuthority)o).getAuthority().equals("ROLE_ADMIN") )
				model.addAttribute("isAdmin", true);
		}

		return "main";
	}
	
	@GetMapping("/leaders")
	public String leaders() {
		return "leaders";
	}

	@GetMapping("/systems")
	public String systems() {
		return "leaders";
	}

}
