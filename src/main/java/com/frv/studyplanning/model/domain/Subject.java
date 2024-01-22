package com.frv.studyplanning.model.domain;

import java.util.ArrayList;

public class Subject extends StudyTime{
	
	private String name;
	private ArrayList<Content> contents = new ArrayList<>();
	public Subject(String name) {
		
		this.name = name;
		
	
		super.setLastDay(null);
		super.setStartDay();
		super.setStartOfStudyMilleseconds();
	}
	
	public String getName() {
		
		return this.name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public ArrayList<Content> getAllContents() {
		
		return this.contents;
	}

	public void addContent(Content content) {
		
		this.contents.add(content);
	}
}
