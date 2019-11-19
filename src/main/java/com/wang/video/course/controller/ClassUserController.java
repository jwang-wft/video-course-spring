package com.wang.video.course.controller;

import java.util.Optional;

import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wang.video.course.entity.ClassUser;
import com.wang.video.course.exception.UserExistsException;
import com.wang.video.course.exception.UserNotFoundException;
import com.wang.video.course.service.ClassUserService;

@RestController()
public class ClassUserController {
	public PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
//	private static Logger logger = Logger.getLogger("ClassUserController");
	@Autowired
	ClassUserService userService;

	@GetMapping("/classusers/{username}")
	public UserDetails getClassUser(@PathVariable String username) throws Exception {
		return userService.loadUserByUsername(username);
	}

	@PostMapping("/classuser")
	public ResponseEntity<ClassUser> createClassUser(@RequestBody ClassUser user) throws Exception {
		Optional<ClassUser> foundUser = userService.findByUsername(user.getUsername());
		if (foundUser.isPresent()) {
			throw new UserExistsException(String.format("User with email: %s already exists.", user.getUsername()));
		}
		user.setPassword(encoder.encode(user.getPassword()));
		ClassUser savedUser = userService.register(user);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedUser);
	}
}
