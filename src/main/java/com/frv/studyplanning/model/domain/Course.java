package com.frv.studyplanning.model.domain;

import java.util.ArrayList;

public class Course extends StudyTime{
	
	private String name;
	private ArrayList<Subject> subjects = new ArrayList<>();
	
	public Course(String name) {
		
		this.name = name;
		super.setHours();
		super.setLastDay(null);
		super.setStartDay();
		super.setStudyHours(null);
	}
	
	@Override
	public void countStudyHours() {
		// TODO Auto-generated method stub
		
	}
	
	public String getName() {
		
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public ArrayList<Subject> getSubjects() {
		
		return subjects;
	}

	public void addSubjects(Subject subject) {
		
		this.subjects.add(subject);
	}
}