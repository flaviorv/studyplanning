package com.frv.studyplanning.model.domain;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_time_goal")
public class TimeGoal extends Goal<Integer>{
	
	private Integer timeGoal = 0;
	@OneToOne(cascade = CascadeType.REMOVE, orphanRemoval = false)
	@JoinColumn(name = "week_id")
	private Week week;
	
	public TimeGoal(Integer timeGoal){
		this.timeGoal = timeGoal;
	}
	
	public TimeGoal() {};
	
	@Override
	public Float calculateDonePercent(Integer studyTime) {
		Float calculation = (float) studyTime/timeGoal*100;
		if(calculation > 100) {
			calculation =  100f;
		}
		return calculation;
	}

	public Integer getTimeGoal() {
		return timeGoal;
	}

	public void setTimeGoal(Integer timeGoal) {
		this.timeGoal = timeGoal;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}
	
}
