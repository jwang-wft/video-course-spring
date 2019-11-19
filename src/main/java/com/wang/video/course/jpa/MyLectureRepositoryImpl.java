package com.wang.video.course.jpa;

import java.math.BigInteger;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.wang.video.course.entity.Lecture;

//https://dzone.com/articles/add-custom-functionality-to-a-spring-data-reposito

@Repository
@Transactional(readOnly = true)
public class MyLectureRepositoryImpl implements MyLectureRepository {
	
	@PersistenceContext
	EntityManager entityManager;

	@Autowired
	LectureRepository lectureRepository;
	
	@Override
	public List<Lecture> findBySectionId(Long topicId, Long sectionId) {
		String sqlString = "select lectures_id from section_lectures where section_id = ?";
		Query query = entityManager.createNativeQuery(sqlString);
		query.setParameter(1, sectionId);
		List<BigInteger> lectureIds = query.getResultList();
		List<Lecture> lectureList = new ArrayList<>();
		for(BigInteger id : lectureIds) {
			Optional<Lecture> lecture = lectureRepository.findById(id.longValueExact());
			if(lecture.isPresent()) {
				lectureList.add(lecture.get());
			}
		}
		return lectureList;
	}

}
