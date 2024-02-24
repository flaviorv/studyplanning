package com.frv.studyplanning.model.domain;

public class TimeGoal extends Goal<Float>{

	private Float TimeGoal;
	
	@Override
	public Float calculateDonePercent(Float studyTime) {
		Float calculation = studyTime/TimeGoal*100;
		setDonePercent(calculation);
		return calculation;
	}
	
	
	
}
