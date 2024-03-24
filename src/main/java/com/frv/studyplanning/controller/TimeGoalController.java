package com.frv.studyplanning.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frv.studyplanning.model.domain.TimeGoal;
import com.frv.studyplanning.model.domain.Week;
import com.frv.studyplanning.model.service.TimeGoalService;

@RestController
@CrossOrigin("*")
public class TimeGoalController {
	@Autowired
	private TimeGoalService timeGoalService;
	
	@PostMapping("/definetimegoal")
	public TimeGoal setTimeGoal(@RequestBody TimeGoal timeGoal) {
		return timeGoalService.saveTimeGoal(timeGoal);
	}
	
	@PostMapping("/timegoal")
	public TimeGoal getTimeGoal(@RequestBody Week week) {
		return timeGoalService.getTimeGoalPerWeek(week.getId());
	}
}
