package com.frv.studyplanning.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.lang.NonNull;
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
	
	public Subject getSubjectPerId(Integer subjectId) {
		return subjectRepository.getSubjectPerId(subjectId);
	}
	
	public Subject saveSubject(Subject subject) {
		subject.setStartDay();
		subject.setLastDay();
		return subjectRepository.save(subject);
	}

}
