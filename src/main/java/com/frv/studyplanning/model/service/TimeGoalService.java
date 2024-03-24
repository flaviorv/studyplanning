package com.frv.studyplanning.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.frv.studyplanning.model.domain.TimeGoal;
import com.frv.studyplanning.model.repository.TimeGoalRepository;

@Service
public class TimeGoalService {
	@Autowired
	private TimeGoalRepository timeGoalRepository;
	
	public TimeGoal getTimeGoalPerWeek(Integer weekId) {
		return timeGoalRepository.getTimeGoalsPerWeek(weekId);
	}
	
	public TimeGoal saveTimeGoal(TimeGoal timeGoal) {
		return timeGoalRepository.save(timeGoal);
	}
	
	public String update(TimeGoal timeGoal) {
		try {
			getTimeGoalPerWeek(timeGoal.getId());
			timeGoalRepository.save(timeGoal);
			String message = "Meta semanal de tempo de estudo atualizada.";
			System.out.println(message);
			return message;
		} catch (Exception e) {
			String message = "Não foi possível atualizar a meta semanal de tempo de estudo.";
			System.out.println(message);
			System.out.println(e.getMessage());
			return message;
		}
	}
}
