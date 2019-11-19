package com.wang.video.course.entity;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Section extends AbstractLesson{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private int sequence;
	
	private long topicId;

    @OneToMany(cascade = CascadeType.ALL, // unidirectional @OneToMany association, parent-side only OneToMany
            fetch = FetchType.LAZY,
            mappedBy = "section")	  // bidirectional One-to-many association
    private Set<Lecture> lectures = new HashSet<>();

    public Section() {
	}

	public Section(long id, String title, int order, String creator, String zipFilePath) {
		this.id = id;
		this.title = title;
		this.sequence = order;
		this.creator = creator;
		this.zipFilePath = zipFilePath;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getSequence() {
		return sequence;
	}

	public void setSequence(int sequence) {
		this.sequence = sequence;
	}

	public long getTopicId() {
		return topicId;
	}

	public void setTopicId(long topicId) {
		this.topicId = topicId;
	}

	public Set<Lecture> getLectures() {
		return lectures;
	}

	public void setLectures(Set<Lecture> lectures) {
		this.lectures = lectures;
	}

}
