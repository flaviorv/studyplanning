package com.frv.studyplanning.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.frv.studyplanning.model.domain.Subject;
import com.frv.studyplanning.model.domain.Week;
import com.frv.studyplanning.model.service.SubjectService;
import com.frv.studyplanning.model.service.WeekService;

@RestController
@CrossOrigin("*")
public class WeekController {
	@Autowired
	private WeekService weekService;
	
	@Autowired
	private SubjectService subjectService;
	
	@PostMapping("/weeks")
	public List<Week> getAllWeeks(@RequestBody Subject subject){
		return  weekService.getAllWeeks(subject.getId());
	}
	
	@PutMapping("/updateweek")
	public Week updateWeek(@RequestBody Week week) {
		return weekService.updateWeek(week);
	}
	
	@PostMapping("/saveweek")
	public Week saveWeek(@RequestBody Week week) {
		week.setStartTime();
		return weekService.saveWeek(week);
	}
	
	@PostMapping("/newweek")
	public Week newWeek(@RequestBody Subject subject) {
		Week newWeek = new Week();
		newWeek.setStartTime();
		newWeek.setStartDay();
		newWeek.setLastDay();
		newWeek.setSubject(subjectService.getSubjectPerId(subject.getId()));
		return saveWeek(newWeek);
	}
	
}
