package com.wang.video.course.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Topic extends AbstractLesson{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5271535459181401101L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	

	public Topic() {}

	public Topic(long id, String title, String creator, String zipFilePath) {
		super();
		this.id = id;
		this.title = title;
		this.creator = creator;
		this.zipFilePath = zipFilePath;
//		this.sections = sections;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

}
