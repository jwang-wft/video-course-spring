package com.wang.video.course.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wang.video.course.entity.Lecture;

@Repository
public interface CombinedLectureRepository extends JpaRepository<Lecture, Long>, MyLectureRepository {

}
