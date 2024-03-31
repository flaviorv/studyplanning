package com.frv.studyplanning.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frv.studyplanning.model.domain.Week;

@RestController
@CrossOrigin("*")
public class StudyTimeController {
	@Autowired
	private WeekController weekController;
	
	@PutMapping("/startsessiontime")
	public Week setSessionTime(@RequestBody Week week) {
		Integer current = week.getCurrentMinutes();
		week.setStartSessionTime(current);
		return weekController.updateWeek(week);
	}
	
	@PutMapping("/calculatestudytime")
	public Week calculateStudyTime(@RequestBody Week week) {
		week.calculateStudyTime(week.getStartSessionTime());
		return weekController.updateWeek(week);
	}
}
