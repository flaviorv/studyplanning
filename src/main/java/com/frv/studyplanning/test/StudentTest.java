package com.frv.studyplanning.test;
import com.frv.studyplanning.model.Student;

public class StudentTest{

	Student s1 = new Student("joao@gmail.com", "joao", "123");
	
	public void showStudent() {
		System.out.println("StudentTest");
		System.out.println("Name: " + s1.getName());
		System.out.println("Email: " + s1.getEmail());
		System.out.println("Password: " + s1.getPassword());		 
	}
}
