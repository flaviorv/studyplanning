package com.frv.studyplanning.model.domain;

import java.util.ArrayList;

public class Course extends StudyTime{
	
	private String name;
	private ArrayList<Subject> subjects = new ArrayList<>();
	
	public String getName() {		
		return name;
	}

	public void setName(String name) {		
		this.name = name;
	}

	public ArrayList<Subject> getSubjects() {
		return subjects;
	}

	public void addSubject(Subject subject) {
		this.subjects.add(subject);
	}

	@Override
	public Integer calculateStudyTime(Integer initTime) {
		// TODO Auto-generated method stub
		return null;
	}
}
