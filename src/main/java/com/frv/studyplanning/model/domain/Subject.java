 package com.frv.studyplanning.model.domain;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

 @Entity
 @Table(name = "tb_subject")
 public class Subject extends StudyTime{
	
	
 	private String name;
// 	@OneToMany
// 	private List<Content> contents;
 	@OneToMany(cascade = CascadeType.REMOVE,  orphanRemoval = true)
 	@JoinColumn(name = "subject_id")
 	private List<Week> weeks;
 	@ManyToOne
 	@JoinColumn(name = "course_id")
 	private Course course;

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	@Override
 	public Integer calculateStudyTime(Integer startTime) {
// 		sum the weeks
 		return 0;
 	} 
	
 	public String getName() {
 		return this.name;
 	}

 	public void setName(String name) {
 		this.name = name;
 	}

// 	public List<Content> getContents() {
// 		return this.contents;
// 	}
//
// 	public void addContent(Content content) {
// 		this.contents.add(content);
// 	}
//
//	public List<Week> getWeeks() {
//		return weeks;
//	}
//
//	public void addWeek(Week week) {
//		this.weeks.add(week);
//	}
 }
