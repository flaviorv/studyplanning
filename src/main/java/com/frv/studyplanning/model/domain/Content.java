package com.frv.studyplanning.model.domain;

import com.frv.studyplanning.model.auxiliary.Constants;

public class Content {
	
	private String type;
	private String description;
	
	public Boolean setType(String type) {
		
		if(type == Constants.CONTENT_LINK) {
		
			this.type = type;
			return true;
		}
		else if(type == Constants.CONTENT_BOOK) {
			
			this.type = type;
			return true;
		}
		else if (type == Constants.CONTENT_KEYPOINT){
			
			this.type = type;
			return true;
		}
		else {
			
			System.out.println("ERROR - Type of Content not allowed - ERROR");
			return false;
		}
	}
	
	public String getType() {
		
		return type;
	}
	
	public Boolean setDescription(String description){
		
		if(type != null) {
			
			this.description = this.type + ": " + description;
			return true;
		}
		else {
			
			System.out.println("ERROR - The type must be defined before set content - ERROR");
			return false;
		}
	}
	
	public String getDesctiption() {
	
		return this.description;
	}
}
