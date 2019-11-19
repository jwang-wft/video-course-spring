package com.wang.video.course.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.wang.video.course.entity.Lecture;
import com.wang.video.course.exception.LectureNotFoundException;
import com.wang.video.course.jpa.LectureRepository;

@CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "*")
@RestController()
public class LectureController {
	@Autowired
	private LectureRepository lectureRepository;
	
	@GetMapping("/lectures")
	public List<Lecture> getAllLectures() {
		return lectureRepository.findAll();
	}
	
	@GetMapping("/topics/{topicId}/sections/{sectionId}")
	public List<Lecture> getAllLecturesBySectionId(@PathVariable Long sectionId) {
		return lectureRepository.findBySectionId(sectionId);
	}
	
	@GetMapping("/topics/{topicId}/sections/{sectionId}/lectures/{id}")
	public Lecture getLectureById(@PathVariable Long id) throws Exception {
		Optional<Lecture> optionalLecture = lectureRepository.findById(id);
		if(!optionalLecture.isPresent()) {
			throw new LectureNotFoundException(String.format("Lecture with id=%s not found.", id));
		}
		return optionalLecture.get();
	}

}
