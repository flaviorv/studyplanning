package com.frv.studyplanning.model.domain;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

public abstract class StudyTime {
	
	private String startDay;
	private String lastDay;
	private String studyHours;
	private String hours;
	
	public void countHours() {
	   
		new Timer().scheduleAtFixedRate(new TimerTask() {
		   
			private Integer count = 0;
		   
			@Override
			public void run() {
				
				if(!new SimpleDateFormat("HH:mm:ss").format(new Date()).equals(getHours())) {
				   
					setHours();
					
					count += 1;
					if(count < 5) {
						
						System.out.println(getHours());
					}	
			   }
		   }
	   }, 0, 100);      
	}
	
	public abstract void countStudyHours();
	
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


	public String getStudyHours() {
		
		return studyHours;
	}

	public void setStudyHours(String studyHours) {
		
		this.studyHours = studyHours;
	}
}