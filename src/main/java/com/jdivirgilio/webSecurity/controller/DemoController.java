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

	public enum Role {
		ROLE_EMPLOYEE("main", 0), ROLE_MANAGER("leaders", 1), ROLE_ADMIN("systems", 2);

		private final String page;
		private final int priority;

		Role(String page, int priority) {
			this.page = page;
			this.priority = priority;
		}

		public String getPage() {
			return page;
		}

		public int getPriority() {
			return priority;
		}

		public int compare(Role that) {
			return Integer.compare(this.priority, that.priority);
		}
	}

	@GetMapping("/")
	public String mainPage(Model model) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String user = auth.getName();
		// These are strings. Look in SecurityConfig.java
		Collection<? extends GrantedAuthority> authorities = auth.getAuthorities();

		model.addAttribute("userName", user);
		model.addAttribute("authorities", authorities);

		ArrayList<Role> roles = new ArrayList<>();

		for (Object o : authorities) {
			roles.add(Role.valueOf(((SimpleGrantedAuthority) o).getAuthority()));
		}

		int numner2 = roles.size();
		Role maxRole = Collections.max(roles);

		return maxRole.getPage();
	}

}
