package com.frv.studyplanning.model.domain;

public class Subject extends CurrentDate{
	
	private String name;
	public Subject(String _name) {
		this.name = _name;
		super.setStartDay();
		super.setStartHour();
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
