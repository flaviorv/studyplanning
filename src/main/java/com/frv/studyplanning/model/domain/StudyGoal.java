package com.frv.studyplanning.model.domain;

import java.util.List;

import org.springframework.context.annotation.Lazy;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_study_goal")
public class StudyGoal extends Goal <List<StudyGoal>>{
	

	private String description;
	@ManyToOne
	@JoinColumn(name = "_week_id")
	private Week week;

	public StudyGoal(String description) {
		this.description = description;
	}
	
	public StudyGoal() {}
	
	@Override
	public Float calculateDonePercent(List<StudyGoal> goals) {
		if(goals.isEmpty()) {
			return 0f;
		}
		float isDone = 0;
		for(StudyGoal g : goals) {
			if(g.isDone()) {
				isDone++;
			}
		}
		Float calculation = isDone/goals.size()*100;
		return calculation;
	}
	
	public String getDescription() {		
		return description;
	}
	
	public void setDescription(String description) {	
		this.description = description;
	}

	public Week getWeek() {
		return week;
	}

	public void setWeek(Week week) {
		this.week = week;
	}


}
