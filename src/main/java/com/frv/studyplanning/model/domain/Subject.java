package com.frv.studyplanning.model.domain;

public class Subject extends StudyTime{
	
	private String name;
	public Subject(String name) {
		this.name = name;
		super.setStartDay();
		super.setStartHour();
		super.countHours();
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
