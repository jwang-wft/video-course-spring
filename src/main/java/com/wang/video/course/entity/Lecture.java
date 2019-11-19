package com.wang.video.course.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="lecture")
public class Lecture extends AbstractLesson{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name="VIDEO_PATH")
	private String videoFilePath;
	@Column(name = "SOURCE_PATH")
	private String sourceFilePath;
	private int sequence;
	private String poster;
	
	@ManyToOne()
	@JoinColumn(name="section_id", nullable=false)
	private Section section;
	

	public Lecture() {
	}

	public Lecture(long id, String title,String creator, String zipFilePath) {
		this.id = id;
		this.title = title;
		this.creator = creator;
		this.zipFilePath = zipFilePath;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getVideoFilePath() {
		return videoFilePath;
	}

	public void setVideoFilePath(String videoFilePath) {
		this.videoFilePath = videoFilePath;
	}

	public String getSourceFilePath() {
		return sourceFilePath;
	}

	public void setSourceFilePath(String sourceFilePath) {
		this.sourceFilePath = sourceFilePath;
	}

//	public Section getSection() {
//		return section;
//	}
//
//	public void setSection(Section section) {
//		this.section = section;
//	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public String getPoster() {
		return poster;
	}

	public void setPoster(String poster) {
		this.poster = poster;
	}


}
