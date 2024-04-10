package com.frv.studyplanning.model.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;
@MappedSuperclass
public abstract class StudyTime {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	@Column(name = "start_day")
	private String startDay;
	@Column(name = "last_day")
	private String lastDay;
	@Column(name = "study_time")
	private Integer studyTime = 0;

	public abstract Integer calculateStudyTime(Integer initTime);
	
	public Integer millisecondsToMinutes(Long milliseconds) {		
		Long minutes = (milliseconds/60000);
		Integer _minutes = minutes.intValue();
		return _minutes;
	}

	public Integer getCurrentMinutes() {
		return millisecondsToMinutes(new Date().getTime() );
	}

	public String getStartDay() {		
		return this.startDay;
	}

	public void setStartDay() {		
		if(this.startDay == null) {		
			this.startDay = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		}
	}

	public String getLastDay() {
		return this.lastDay;
	}

	public void setLastDay(){
		this.lastDay = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
	}
	
	public void setLastDay(String day) {
		this.lastDay = day;
	}

	public Integer getStudyTime() {
		return this.studyTime;
	}

	public void setStudyTime(Integer studyTime) {
		this.studyTime = studyTime;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}