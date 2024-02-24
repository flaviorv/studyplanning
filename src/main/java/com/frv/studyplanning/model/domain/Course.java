package com.frv.studyplanning.model.domain;

public class Course extends StudyTime{
	
	private String name;
	private Student student;
	
	@Override
	public String toString() {
		return "Curso "+name+" Estudante "+student.getName();
	}
	
	public String getName() {		
		return name;
	}

	public void setName(String name) {		
		this.name = name;
	}

	@Override
	public Integer calculateStudyTime(Integer initTime) {
		// TODO Auto-generated method stub
		return null;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}
}
