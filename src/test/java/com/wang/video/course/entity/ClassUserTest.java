package com.wang.video.course.entity;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.assertj.core.util.Arrays;
import org.junit.Before;
import org.junit.Test;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

public class ClassUserTest {
	public PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
	ClassUser user;
	@Before
	public void setUp() throws Exception {
		String username = "jwang@gmail.com";
		String password = encoder.encode("password");
		Stream s = Stream.of("USER", "ADMIN");
		List<String> roles = (List<String>) s.collect(Collectors.toList());
		user = new ClassUser();
		user.setPassword(password);
		user.setUsername(username);
		user.setRoles(roles);;
	}
	

	@Test
	public void test() {
		System.out.printf("username: %s; \npassword: %s\n",user.getUsername(), user.getPassword());
		Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) user.getAuthorities();
		for(GrantedAuthority g : authorities) {
			System.out.printf("Authority: %s\n", g);
		}
		
		System.out.println(user.getClass().getName());
	}

}
