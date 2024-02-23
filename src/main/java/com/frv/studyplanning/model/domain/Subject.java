 package com.frv.studyplanning.model.domain;

 import java.util.ArrayList;

 public class Subject extends StudyTime{
	
 	private String name;
 	private ArrayList<Content> contents = new ArrayList<>();
 	private ArrayList<Week> weeks = new ArrayList<>();

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

 	public ArrayList<Content> getContents() {
 		return this.contents;
 	}

 	public void addContent(Content content) {
 		this.contents.add(content);
 	}

	public ArrayList<Week> getWeeks() {
		return weeks;
	}

	public void addWeek(Week week) {
		this.weeks.add(week);
	}
 }
