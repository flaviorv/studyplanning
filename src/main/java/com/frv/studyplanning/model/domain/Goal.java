package com.frv.studyplanning.model.domain;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

@MappedSuperclass
public abstract class Goal <T>{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Boolean done = false;


	public abstract Float calculateDonePercent(T any);

	public Boolean isDone() {	
		return done;
	}
	
	public void alterDone() {	
		if(this.done == false) {
			this.done = true;
		}else {
			this.done = false;
		}
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
