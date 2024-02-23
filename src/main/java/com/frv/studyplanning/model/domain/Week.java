package com.frv.studyplanning.model.domain;

import java.util.ArrayList;

public class Week extends StudyTime {
	
	private Integer id;
	private Integer startTime;
	private ArrayList<Goal> goals = new ArrayList<>();
	private Integer points;
	private String feedback;
	private Boolean ended;
	
	private Integer startSessionTime;
	@Override
	public Integer calculateStudyTime(Integer startSessionTime) {
		Integer studySessionTime = super.getCurrentMinutes() - startSessionTime;
		if(super.getStudyTime() != null) {
			super.setStudyTime(studySessionTime + super.getStudyTime());
		}
		else {
			super.setStudyTime(studySessionTime);
		}
		return super.getStudyTime();
	}
	
	public Boolean setEnded() {
		Integer weekTime = super.getCurrentMinutes() - startTime;
		if(weekTime >= 10080) {
			return this.ended = true;
		}	
		return this.ended = false;
	}
	
	public Boolean isEnded() {
		return this.ended;
	}
	
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getStartTime() {
		return this.startTime;
	}

	public void setStartTime() {
		if(startTime == null) {
			this.startTime = super.getCurrentMinutes();
		}
	}
	
	//for test
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public ArrayList<Goal> getGoals() {		
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
	
	public Integer getStartSessionTime() {
		return startSessionTime;
	}

	public void setStartSessionTime() {
		this.startSessionTime = super.getCurrentMinutes();
	}
}
