package com.wang.video.course.jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wang.video.course.entity.Topic;

public interface TopicRepository extends JpaRepository<Topic, Long>{

}
