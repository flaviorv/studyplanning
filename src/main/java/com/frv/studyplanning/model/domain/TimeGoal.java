package com.frv.studyplanning.model.domain;

public class TimeGoal extends Goal<Integer>{

	private Integer timeGoal;
	
	public TimeGoal(Integer timeGoal){
		this.timeGoal = timeGoal;
	}
	
	@Override
	public Float calculateDonePercent(Integer studyTime) {
		Float calculation = (float) studyTime/timeGoal*100;
		if(calculation > 100) {
			calculation = (float) 100;
		}
		return calculation;
	}

	public Integer getTimeGoal() {
		return timeGoal;
	}

	public void setTimeGoal(Integer timeGoal) {
		this.timeGoal = timeGoal;
	}
	
}
