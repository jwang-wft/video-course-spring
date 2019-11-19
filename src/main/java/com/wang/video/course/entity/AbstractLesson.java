package com.wang.video.course.entity;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@MappedSuperclass
public class AbstractLesson extends AuditModel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@NotNull
	@Size(max = 100)
	protected String title;
	protected String creator;
	@Column(name="ZIP_PATH")
	protected String zipFilePath;

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

	public String getZipFilePath() {
		return zipFilePath;
	}

	public void setZipFilePath(String zipFilePath) {
		this.zipFilePath = zipFilePath;
	}

}
