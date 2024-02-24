package com.frv.studyplanning.model.domain;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_student")
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "email")
	private String email;
	@Column(name = "password")
	private String password;
	
	public Student() {}
	
	public Student(String name, String email,  String password) {		
		this.name = name;
		this.email = email;
		this.password = password;
	}
	
	@Override
	public String toString() {
		String strTest = "Nome: "+name+" Email: "+email+" Senha: "+password;
		System.out.println(strTest);
		return strTest;
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
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
}
