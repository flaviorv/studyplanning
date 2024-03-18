package com.frv.studyplanning.model.domain;

import com.frv.studyplanning.model.auxiliary.Constants;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_week")
public class Week extends StudyTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "start_time")
	private Integer startTime;
	@Column(name = "done_percent")
	private Float donePercent;
	@Column(name = "time_done_percent")
	private Float timeDonePercent;
	private Integer points;
	private String feedback;
	private Boolean ended;
	@ManyToOne
	@JoinColumn(name = "id_subject")
	private Subject subject;
//	@OneToOne
//	private TimeGoal timeGoal;
//	@OneToMany
//	private List<StudyGoal> goals;
	
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
		this.setPoints(average);
		return average;
	}
	
	public String generateFeedback() {
		if(this.points == 10) {
			return Constants.BEST_FEEDBACK;
		}
		else if(this.points > 7){
			return Constants.GOOD_FEEDBACK;
		}
		else if(this.points < 7) {
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
	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}
}
