package com.frv.studyplanning.model.domain;

import java.util.ArrayList;

public class Week extends StudyTime {
	
	private Integer id;
	private Integer startTime;
	private ArrayList<StudyGoal> goals = new ArrayList<>();
	private Float donePercent;
	private Float timeDonePercent;
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
	
	public Integer calculatePoints() {
		Float goalsPercent = this.getDonePercent();
		Float timePercent = this.getTimeDonePercent();	
		Integer average = (int) ((goalsPercent+timePercent)/20);
		this.setPoints(average);
		return average;
	}
	
	public String generateFeedback() {
		if(this.points == 10) {
			return "Parabéns você bateu todas as metas";
		}
		else if(this.points > 7){
			return "Você foi muito bem, mas pode melhorar";
		}
		else if(this.points < 7) {
			return "Você precisa se dedicar mais";
		}
		else {
			return "Não foi possível gerar feedback";
		}
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

	public ArrayList<StudyGoal> getGoals() {		
		return goals;
	}
	
	public void addGoal(StudyGoal goal) {		
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

	public Float getDonePercent() {
		return donePercent;
	}

	public void setDonePercent(Float donePercent) {
		this.donePercent = donePercent;
	}

	public Float getTimeDonePercent() {
		return timeDonePercent;
	}

	public void setTimeDonePercent(Float timeDonePercent) {
		this.timeDonePercent = timeDonePercent;
	}
}
