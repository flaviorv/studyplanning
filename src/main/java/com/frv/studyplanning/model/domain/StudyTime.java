package com.frv.studyplanning.model.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public abstract class StudyTime {
	
	private String startDay;
	private String lastDay;
	private String studyDays;
	private String startHour;
	private String studyHours;
	private String hours;
	
	public void countHours() {
	   new Timer().scheduleAtFixedRate(new TimerTask() {
		   @Override
		   public void run() {
			   if(!new SimpleDateFormat("HH:mm:ss").format(new Date()).equals(getHours())) {
				   setHours();
				   System.out.println(getHours());
			   }
		   }
	   }, 0, 100);      
	}
	
	public String getHours() {
		return this.hours;
	}
	
	public void setHours() {
		this.hours = new SimpleDateFormat("HH:mm:ss").format(new Date());
	}

	public String getStartDay() {
		return this.startDay;
	}

	public void setStartDay() {
		if(this.getStartDay() == null) {
			this.startDay = new SimpleDateFormat("dd/MM/yyyy").format(new Date());
		}
	}

	public String getLastDay() {
		return lastDay;
	}

	public void setLastDay(String lastDay) {
		this.lastDay = lastDay;
	}

	public String getStudyDays() {
		return studyDays;
	}

	public void setStudyDays(String studyDays) {
		this.studyDays = studyDays;
	}

	public String getStartHour() {
		return startHour;
	}

	public void setStartHour() {
		if (this.getStartHour() == null) {
			this.startHour = new SimpleDateFormat("HH:mm:ss").format(new Date());
		}
	}

	public String getStudyHours() {
		return studyHours;
	}

	public void setStudyHours(String studyHours) {
		this.studyHours = studyHours;
	}
}
