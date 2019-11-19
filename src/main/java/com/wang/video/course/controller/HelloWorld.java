package com.wang.video.course.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@GetMapping({"/", "/hello"})
	public String sayHello() {
		return "<h1>Welcome to Video Course Online!</h1>";
	}
}
