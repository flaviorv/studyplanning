package com.frv.studyplanning.model.domain;

public abstract class Goal <T>{
	
	private Boolean done = false;
	private Float donePercent;
	
	public abstract Float calculateDonePercent(T any);

	public Boolean isDone() {	
		return done;
	}
	
	public void setDone() {	
		if(this.done == false) {
			this.done = true;
		}else {
			this.done = false;
		}
	}

	public Float getDonePercent() {
		return donePercent;
	}

	public void setDonePercent(Float donePercent) {
		this.donePercent = donePercent;
	}
}
