package com.jdivirgilio.webSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

	@GetMapping("myLoginPage") // Must match what's in SecurityConfig.java
	public String myLoginPage() {
		return "fancy-login";
	}
	
	@GetMapping("accessDenied") // Could go anywhere
	public String accessDeniedPage() {
		return "accessDenied";
	}
}
