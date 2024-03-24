package com.frv.studyplanning.model.domain;

import java.util.List;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.experimental.SuperBuilder;

@Entity
@Table(name = "tb_study_goal")
public class StudyGoal extends Goal <List<StudyGoal>>{
	

	private String description;
	@ManyToOne
	@JoinColumn(name = "week_id")
	private Week week;

	public StudyGoal(String description) {
		this.description = description;
	}
	
	public StudyGoal() {}
	
	@Override
	public Float calculateDonePercent(List<StudyGoal> goals) {
		float amount = 0;
		float isDone = 0;
		for(StudyGoal g : goals) {
			amount++;
			if(g.isDone() == true) {
				isDone++;
			}
		}
		Float calculation = isDone/amount*100;
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
