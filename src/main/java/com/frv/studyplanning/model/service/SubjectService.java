package com.frv.studyplanning.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frv.studyplanning.model.domain.Subject;
import com.frv.studyplanning.model.repository.SubjectRepository;

@Service
public class SubjectService {
	@Autowired
	private SubjectRepository subjectRepository;
	
	public List<Subject> getAllSubjects(Integer idCourse) {
		return subjectRepository.getAllSubjects(idCourse);
	}
	
	public Subject saveSubject(Subject subject) {
		return subjectRepository.save(subject);
	}

}
