package com.wang.video.course.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	BCryptPasswordEncoder encoder;
	
	/**
	 * 1. http://localhost:8080 or http://localhost:8080/home do not need any security
	 * 2. http://localhot:8080/user needs to have "USER" role
	 * 3. http://localhost:8080/admin needs to have "ADMIN" role
	 * 4. except /, /home, all other request need login with customer login.html page.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/", "/home", "/sections", "/topics", "/classusers").permitAll().antMatchers("/admin").hasRole("ADMIN")
				.anyRequest().authenticated().and().formLogin().loginPage("/login").permitAll().and().logout()
				.permitAll();
		http.exceptionHandling().accessDeniedPage("/403");
	}

	/*
	 * 1. with User Name = "user", password = "user" will have "USER" role;
	 * 2. with User Name = "admin", password = "admin" will have "ADMIN" role;
	 */
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("user").password(encoder.encode("user")).roles("USER").and().withUser("admin")
				.password(encoder.encode("admin")).roles("ADMIN");
	}
}
