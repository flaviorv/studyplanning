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
	
	public String alterStudyGoalIsDone(Integer studyGoalId) {
		String message = "";
		try {
			StudyGoal studyGoal = getStudyGoalPerId(studyGoalId);
			studyGoal.alterDone();
			if(studyGoal.isDone()) {
				message = "Objetivo de estudo " + studyGoal.getId() + " concluído.";
				System.out.println(message);
				return message;
			}
			message = "Concluir objetivo de estudo " + studyGoal.getId();
			System.out.println(message);
			return message;
		} catch (Exception e) {
			message = "Erro ao atualizar objetivo de estudo.";
			System.out.println(message);
			System.out.println(e.getMessage());
			return message;
		}
	}
}
