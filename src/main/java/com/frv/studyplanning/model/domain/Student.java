package com.frv.studyplanning.model.domain;

public class Student {
	
	private String name;
	private String email;
	private String password;
	
	public Student(String name,String email,  String password) {
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	public Boolean authenticate(String password) {
		if(this.password == password) {
			return true;
		}
		return false;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
