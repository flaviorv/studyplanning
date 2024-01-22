package com.frv.studyplanning.model.domain;

import java.util.ArrayList;

public class Week {
	
	private ArrayList<String> goals = new ArrayList<>();
	private Integer points;
	private String feedback;
	
	public ArrayList<String> getAllGoals() {
		
		return goals;
	}
	
	public void addGoal(String goal) {
		
		this.goals.add(goal);
	}
	
	public Integer getPoints() {
		
		return points;
	}
	
	public void setPoints(Integer points) {
		
		this.points = points;
	}
	
	public String getFeedback() {
		
		return feedback;
	}
	
	public void setFeedback(String feedback) {
		
		this.feedback = feedback;
	}
}
