package com.wang.video.course.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wang.video.course.entity.Topic;
import com.wang.video.course.exception.TopicNotFoundException;
import com.wang.video.course.jpa.TopicRepository;

//@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController
public class TopicController {
	@Autowired
	private TopicRepository repository;
	
	@GetMapping("/topics")
	public List<Topic> getAllTopics() {
		return repository.findAll();
	}
	
	@GetMapping("/topics/{id}")
	public Topic getTopicById(@PathVariable long id) throws Exception {
		Optional<Topic> topicOptional = repository.findById(id);
		if(!topicOptional.isPresent()) {
			throw new TopicNotFoundException(String.format("No topic with id=%s found.", id));
		}
		return topicOptional.get();
	}
	
	@PostMapping("/topics")
	public Topic createTopic(@RequestBody Topic topic) {
		Date today = new Date();
		topic.setCreatedAt(today);
		topic.setUpdatedAt(today);
		return repository.save(topic);
	}
}
