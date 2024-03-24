package com.frv.studyplanning.model.domain;

import java.util.ArrayList;
import java.util.List;

import com.frv.studyplanning.model.auxiliary.Constants;
import com.frv.studyplanning.model.domain.TimeGoal;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_week")
public class Week extends StudyTime {
	
	
	@Column(name = "start_time")
	private Integer startTime;
	@Column(name = "done_percent")
	private Float donePercent;
	@Column(name = "time_done_percent")
	private Float timeDonePercent;
	private Boolean ended;
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "week_id")
	private List<StudyGoal> goals = new ArrayList<StudyGoal>();

	
	

	public List<StudyGoal> getGoals() {
		return goals;
	}

	public void addGoal(StudyGoal goal) {
		this.goals.add(goal);
	}

	public Week() {}
	
	@Transient
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
		return average;
	}
	
	public String generateFeedback() {
		if(calculatePoints() == 10) {
			return Constants.BEST_FEEDBACK;
		}
		else if(calculatePoints() > 7){
			return Constants.GOOD_FEEDBACK;
		}
		else if(calculatePoints() < 7) {
			return Constants.BAD_FEEDBACK;
		}
		else {
			return Constants.NO_FEEDBACK;
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
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
