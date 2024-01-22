package com.frv.studyplanning.model.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class StudyTime {
	
	private String startDay;
	private String lastDay;
	private Integer studyMinutes;
	
	private Long startOfStudyMilliseconds;
	public Boolean calculateStudyMinutes() {
		try {
			
			Long studyMilliseconds = new Date().getTime() - startOfStudyMilliseconds;
			Long studySeconds = (studyMilliseconds/1000);
			Integer studyIntSeconds = studySeconds.intValue();
			studyMinutes = studyIntSeconds/60;
			return true;
		}
		catch(Exception e) {
			
			return false;
		}
	}
	
	public void setStartOfStudyMilleseconds() {
		
		startOfStudyMilliseconds = new Date().getTime();
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


	public Integer getStudyMinutes() {
		
		return studyMinutes;
	}
}