package com.frv.studyplanning.model.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_course")
public class Course extends StudyTime{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String name;
	@ManyToOne
	@JoinColumn(name = "id_student")
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
