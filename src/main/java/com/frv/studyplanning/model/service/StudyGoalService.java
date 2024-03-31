package com.frv.studyplanning.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frv.studyplanning.model.domain.StudyGoal;
import com.frv.studyplanning.model.repository.StudyGoalRepository;

@Service
public class StudyGoalService {
	@Autowired
	private StudyGoalRepository studyGoalRepository;
	
	public List<StudyGoal> getStudyGoalsPerWeek(Integer weekId){
		return studyGoalRepository.getStudyGoalsPerWeek(weekId);
	}
	
	public StudyGoal getStudyGoalPerId(Integer studyGoalId) {
		return studyGoalRepository.getStudyGoalPerId(studyGoalId);
	}
	
	public StudyGoal saveStudyGoal(StudyGoal studyGoal) {
		return studyGoalRepository.save(studyGoal);
	}
	
}
