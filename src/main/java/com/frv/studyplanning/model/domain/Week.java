package com.frv.studyplanning.model.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import com.frv.studyplanning.model.auxiliary.Constants;

import ch.qos.logback.core.net.SyslogOutputStream;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;

@Entity
@Table(name = "tb_week")
public class Week extends StudyTime {
	
	@Column(name = "start_time")
	private Integer startTime = 0;
	
	@Column(name = "start_session_time")
	private Integer startSessionTime = 0;
	
	private Boolean ended = false;
	
	@ManyToOne
	@JoinColumn(name = "subject_id")
	private Subject subject;
	
	public Week() {}
	
	@Override
	public String toString() {
		String str = "startSessionTime "+startSessionTime.toString()+"\n"+
				"startTime "+startTime.toString()+"\n"+
				"ended "+ended.toString()+"\n"+
				"studytime "+getStudyTime().toString()+"\n"
				;
		return str;
	}
	@Override
	public Integer calculateStudyTime(Integer startSession) {
		Integer studySessionTime = getCurrentMinutes() - startSession;
		setStudyTime(studySessionTime + getStudyTime());
		return getStudyTime();
	}
	
	public Integer calculateStudyTime() {
		setStudyTime(getStudyTime() + 1);
		return getStudyTime();
	}
	
	public Integer calculatePoints(Float timePercent, Float goalsPercent) {
		Integer average = (int) ((goalsPercent+timePercent)/20);
		return average;
	}
	
	
	public String generateFeedback(Integer points) {
		if(points == 10) {
			return Constants.BEST_FEEDBACK;
		}
		else if(points > 7){
			return Constants.GOOD_FEEDBACK;
		}
		else if(points < 7) {
			return Constants.BAD_FEEDBACK;
		}
		else {
			return Constants.NO_FEEDBACK;
		}
	}
	
	@Override
	public void setLastDay() {
		Long currentMilliseconds = new Date().getTime();
		Long lastMilliseconds = currentMilliseconds + 604800000;
		super.setLastDay( new SimpleDateFormat("dd/MM/yyyy").format(new Date(lastMilliseconds)));
	}
	
	public Boolean setEnded() {
		ended = false;
		Integer weekTime = getCurrentMinutes() - startTime;
		if(weekTime >= 10080) {
			ended = true;
		}	
		return ended;
	}
	
	public Boolean isEnded() {
		return ended;
	}

	public Integer getStartTime() {
		return this.startTime;
	}

	public void setStartTime() {
		startTime = getCurrentMinutes();
	}
	
	//for test
	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
		
	}
	
	public Integer getStartSessionTime() {
		return startSessionTime;
	}

	public void setStartSessionTime() {
		startSessionTime = getCurrentMinutes();
	}
	
	public void setStartSessionTime(Integer startSessionTime) {
		this.startSessionTime = startSessionTime;
	}

	
	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	

}
