package com.frv.studyplanning.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.frv.studyplanning.model.domain.StudyGoal;
import com.frv.studyplanning.model.domain.Subject;
import com.frv.studyplanning.model.domain.TimeGoal;
import com.frv.studyplanning.model.domain.Week;
import com.frv.studyplanning.model.service.WeekService;

@RestController
@CrossOrigin("*")
public class WeekController {
	@Autowired
	private WeekService weekService;
	
	@Autowired
	private SubjectController subjectController;
	
	@Autowired
	private TimeGoalController timeGoalController;
	
	@Autowired
	private StudyGoalController studyGoalController;
	

	
	@PostMapping("/weeks")
	public List<Week> getAllWeeks(@RequestBody Subject subject){
		return  weekService.getAllWeeks(subject.getId());
	}
	
	@PutMapping("/updateweek")
	public Week updateWeek(@RequestBody Week week) {
		return weekService.saveWeek(week);
	}
	
	@PostMapping("/saveweek")
	public Week saveWeek(@RequestBody Week week) {
		return weekService.saveWeek(week);
	}
	
	@PostMapping("/newweek")
	public Week newWeek(@RequestBody Subject subject) {
		Week newWeek = new Week();
		newWeek.setStartTime();
		newWeek.setStartDay();
		newWeek.setLastDay();
		newWeek.setSubject(subjectController.getSubjectPerId(subject));
		return saveWeek(newWeek);
	}
	
	@PostMapping("/generatefeedback")
	public String checkended(@RequestBody Week week) {
		Week _week = weekById(week);
		_week.setEnded();
		if(_week.isEnded()) {
			TimeGoal timeGoal = timeGoalController.getTimeGoal(_week);
			Float tgDonePercent = timeGoal.calculateDonePercent(_week.getStudyTime());
			Float stDonePercent = new StudyGoal().calculateDonePercent(
				studyGoalController.studyGoalsPerWeek(_week)
			);
			
			Integer points = _week.calculatePoints(tgDonePercent, stDonePercent);
			String feedback = _week.generateFeedback(points);
			String _feedback = feedback+","+ 
					"Meta de tempo concluída: "+Math.round(tgDonePercent)+"%,"+
					"Metas concluídas: "+Math.round(stDonePercent)+"%,"+
					"Pontuação: "+points;
			updateWeek(_week);
			return _feedback;
		}
		return "Semana ainda não terminou.";
	}
	
	@PostMapping("/weekbyid")
	public Week weekById(@RequestBody Week week) {
		return weekService.getWeekById(week.getId());
	}
	

	
	
	
}
