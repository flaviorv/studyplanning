package com.frv.studyplanning.model.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.hibernate.annotations.Parent;
import org.springframework.context.annotation.Lazy;

import com.frv.studyplanning.model.auxiliary.Constants;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
	public Integer calculateStudyTime(Integer startSessionTime) {
		Integer studySessionTime = getCurrentMinutes() - startSessionTime;
		super.setStudyTime(studySessionTime + getStudyTime());
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
		Integer weekTime = super.getCurrentMinutes() - startTime;
		if(weekTime >= 10080) {
			return ended = true;
		}	
		return ended = false;
	}
	
	public Boolean isEnded() {
		return this.ended;
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
