package com.jdivirgilio.webSecurity.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource ds;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.jdbcAuthentication().dataSource(ds); // Reads users from DB and uses this as authentication
		
//		// Add our users for in-mem auth
//		
//		UserBuilder users = User.withDefaultPasswordEncoder();
//		
//		auth.inMemoryAuthentication()
//			.withUser(users.username("john").password("test123").roles("EMPLOYEE"))
//			.withUser(users.username("rachael").password("test123").roles("EMPLOYEE", "MANAGER"))
//			.withUser(users.username("johnny").password("test123").roles("ADMIN", "MANAGER", "EMPLOYEE"));
	}

	/* (non-Javadoc)
	 * @see org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter#configure(org.springframework.security.config.annotation.web.builders.WebSecurity)
	 */
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//
//		http.authorizeRequests()
//			.antMatchers("/").hasRole("EMPLOYEE")
//			.antMatchers("/leaders/**").hasRole("MANAGER")
//			.antMatchers("/systems/**").hasRole("ADMIN")
//			.and()
//			.formLogin()
//				.loginPage("/myLoginPage") // We create this controller to map to this page..see LoginController.java
//				.loginProcessingUrl("/authenticateUser") // No controller request mapping ... this is provided by the framework
//				.permitAll()
//			.and()
//				.logout().permitAll() // adds logout support default url is /logout
//									   // This is free..not code required..sent directly to the security filters
//			.and()
//				.exceptionHandling().accessDeniedPage("/accessDenied"); // Can be anything .. just a page ref
//	}

	}
