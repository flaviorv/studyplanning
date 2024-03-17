 package com.frv.studyplanning.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

 @Entity
 @Table(name = "tb_subject")
 public class Subject extends StudyTime{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
 	private String name;
// 	@OneToMany
// 	private List<Content> contents;
// 	@OneToMany
// 	private List<Week> weeks;
 	@ManyToOne
 	@JoinColumn(name = "id_course")
 	private Course course;

 	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

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
