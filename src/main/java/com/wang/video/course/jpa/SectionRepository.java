package com.wang.video.course.jpa;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wang.video.course.entity.Section;

public interface SectionRepository extends JpaRepository<Section, Long> {
	List<Section> findByTopicId(Long topicId);
}
