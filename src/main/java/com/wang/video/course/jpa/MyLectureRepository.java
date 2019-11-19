package com.wang.video.course.jpa;

import java.util.List;

import com.wang.video.course.entity.Lecture;

public interface MyLectureRepository {
	List<Lecture> findBySectionId(Long topicId, Long sectionId);

}
