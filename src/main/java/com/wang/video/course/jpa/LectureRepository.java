package com.wang.video.course.jpa;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wang.video.course.entity.Lecture;

@Repository
public interface LectureRepository extends JpaRepository<Lecture, Long>{
	List<Lecture> findBySectionId(Long sectionId);
	Optional<Lecture> findById(Long id);
}
