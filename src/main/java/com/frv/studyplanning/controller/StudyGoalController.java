package com.frv.studyplanning.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frv.studyplanning.model.domain.StudyGoal;
import com.frv.studyplanning.model.domain.Week;
import com.frv.studyplanning.model.service.StudyGoalService;

@RestController
@CrossOrigin("*")
public class StudyGoalController {
	@Autowired
	private StudyGoalService studyGoalService;
	
	@PostMapping("/savestudygoal")
	public StudyGoal saveStudyGoal(@RequestBody StudyGoal studyGoal) {
		return studyGoalService.saveStudyGoal(studyGoal);
	}
	
	@PostMapping("/studygoals")
	public List<StudyGoal> studyGoalsPerWeek(@RequestBody Week week){
		return studyGoalService.getStudyGoalsPerWeek(week.getId());
	}
	
	@PutMapping("/updatestudygoal")
	public StudyGoal setDone(@RequestBody StudyGoal studyGoal) {
		return studyGoalService.saveStudyGoal(studyGoal);
	}
}
