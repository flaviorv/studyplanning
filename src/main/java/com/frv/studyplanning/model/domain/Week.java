package com.frv.studyplanning.model.domain;

import java.util.ArrayList;

public class Week extends StudyTime {
	
	private ArrayList<Goal> goals = new ArrayList<>();
	private Integer points;
	private String feedback;
	
	public Week() {
		
		super.setLastDay(null);
		super.setStartDay();
		super.setStartOfStudyMilleseconds();
	}
	
	public ArrayList<Goal> getAllGoals() {
		
		return goals;
	}
	
	public void addGoal(Goal goal) {
		
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
