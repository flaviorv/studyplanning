package com.frv.studyplanning.model.domain;

public abstract class Goal <T>{
	
	private Boolean done = false;
	
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

	
}
