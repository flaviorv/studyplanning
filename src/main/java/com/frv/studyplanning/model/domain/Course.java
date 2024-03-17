package com.frv.studyplanning.model.domain;

import java.util.List;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
	@OneToMany(cascade = CascadeType.REMOVE, orphanRemoval = true)
	@JoinColumn(name = "id_course")
	private List<Subject> subjects;
	
	public Course() {}
	
	@Override
	public Integer calculateStudyTime(Integer initTime) {
		// TODO Auto-generated method stub
		return null;
	}

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
