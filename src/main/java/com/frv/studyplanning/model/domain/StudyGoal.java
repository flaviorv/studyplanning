package com.frv.studyplanning.model.domain;

import java.util.ArrayList;

public class StudyGoal extends Goal <ArrayList<StudyGoal>>{
	
	private String description;
	
	public StudyGoal(String description) {
		this.description = description;
	}
	
	@Override
	public Float calculateDonePercent(ArrayList<StudyGoal> goals) {
		float amount = 0;
		float isDone = 0;
		for(StudyGoal g : goals) {
			amount++;
			if(g.isDone() == true) {
				isDone++;
			}
		}
		Float calculation = isDone/amount*100;
		setDonePercent(calculation);
		return calculation;
	}
	
	public String getDescription() {		
		return description;
	}
	
	public void setDescription(String description) {	
		this.description = description;
	}


}
