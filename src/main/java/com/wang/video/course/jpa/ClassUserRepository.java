package com.wang.video.course.jpa;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.wang.video.course.entity.ClassUser;

public interface ClassUserRepository extends JpaRepository<ClassUser, Long> {
	public Optional<ClassUser> findByUsername(String username);
	public Integer countByUsername(String username);
    void deleteById(Long id);

}
