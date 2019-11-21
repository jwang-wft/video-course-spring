package com.wang.video.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wang.video.course.entity.ClassUser;
import com.wang.video.course.exception.UserExistsException;
import com.wang.video.course.jpa.ClassUserRepository;

@RestController()
public class ClassUserController {
//	private static Logger logger = Logger.getLogger("ClassUserController");
	@Autowired
	ClassUserRepository userRepository;
	
	@GetMapping("/classusers")
	public List<ClassUser> getAllUser() throws Exception {
		return userRepository.findAll();
	}
	
	@GetMapping("/classusers/{username}")
	public ClassUser getClassUser(@PathVariable String username) throws Exception {
		return userRepository.findByUsername(username).get();
	}

	@PostMapping("/classusers")
	public ClassUser createUser(@RequestBody ClassUser user) throws Exception {
		Optional<ClassUser> foundUser = userRepository.findByUsername(user.getUsername());
		if (foundUser.isPresent()) {
			throw new UserExistsException(String.format("User with email: %s already exists.", user.getUsername()));
		}
		userRepository.save(user);
		return user;
	}
	
}
