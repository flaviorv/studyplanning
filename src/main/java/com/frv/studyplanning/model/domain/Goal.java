package com.frv.studyplanning.model.domain;

public class Goal {
	
	private String description;
	private Boolean done;
	
	public String getDescription() {
		
		return description;
	}
	
	public void setDescription(String description) {
	
		this.description = description;
	}
	
	public Boolean isDone() {
	
		return done;
	}
	
	public void setDone(Boolean done) {
	
		this.done = done;
	}
}
