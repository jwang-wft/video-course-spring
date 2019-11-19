package com.wang.video.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wang.video.course.entity.Section;
import com.wang.video.course.exception.SectionNotFoundException;
import com.wang.video.course.jpa.SectionRepository;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController()
public class SectionController {
	@Autowired
	private SectionRepository sectionRepository;

	@GetMapping("/sections")
	public List<Section> getAllSections() {
		return sectionRepository.findAll();
	}

	@GetMapping("/sections/{id}")
	public Section getSection(@PathVariable Long id) throws Exception {
		Optional<Section> optionalSection = sectionRepository.findById(id);
		if (!optionalSection.isPresent()) {
			throw new SectionNotFoundException(String.format("Section with id=%s not found.", id));
		}
		return optionalSection.get();
	}

	@GetMapping("/sections/topic/{topicId}")
	public List<Section> getAllSectionsByTopicId(@PathVariable Long topicId) {
		return sectionRepository.findByTopicId(topicId);
	}

}