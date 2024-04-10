package com.frv.studyplanning.controller;

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
		Week _week = weekController.weekById(week);
		Integer current = week.getCurrentMinutes();
		_week.setStartSessionTime(current); 
		return weekController.updateWeek(_week);
	}
	
	@PutMapping("/calculatestudytime")
	public Week calculateStudyTime(@RequestBody Week week) {
		Week _week = weekController.weekById(week);
		_week.calculateStudyTime();
		return weekController.saveWeek(_week);
	}
}
