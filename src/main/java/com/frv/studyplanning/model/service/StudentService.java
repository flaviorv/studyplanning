package com.frv.studyplanning.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Service;
import com.frv.studyplanning.model.domain.Student;
import com.frv.studyplanning.model.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
	private StudentRepository studentRepository;
	
	public Student saveStudent(@NonNull Student student) {
		return studentRepository.save(student);
	}
	
	public Student authenticate(Student student) {		
		return studentRepository.authenticate(student.getEmail(), student.getPassword());
	}
}
