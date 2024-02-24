package com.frv.studyplanning;

import java.util.Timer;
import java.util.TimerTask;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.frv.studyplanning.model.domain.StudyGoal;
import com.frv.studyplanning.model.domain.Week;

@Order(5)
@Component
public class WeekLoader implements ApplicationRunner{
	
	public void run(ApplicationArguments args) {
		System.out.println("Starting WeekLoader");
		Week w1 = new Week();
		w1.setStartSessionTime();
		StudyGoal g1 = new StudyGoal("Ler capítulo 6 e 7 de Disciplined Agile Delivery");
		g1.setDone();
		w1.addGoal(g1);
		w1.addGoal(new StudyGoal("Ler capítulo 1 e 15 de Applying UML and Patterns"));
		w1.addGoal(new StudyGoal("Implementar database no Studyplanning"));
		System.out.println(g1.calculateDonePercent(w1.getGoals()));
		new Timer().scheduleAtFixedRate(new TimerTask(){
			private Integer iterations = 0;
			@Override
			public void run(){
				if(iterations == 3) {
					iterations = 0;
					w1.setStartSessionTime();
				}
				System.out.println("Session will restart in "+(3-iterations)+" iterations");
				iterations++;
				//setStartTime is only altered if null(what sholdn't occur)
		    	w1.setStartTime();
		    	w1.calculateStudyTime(w1.getStartSessionTime());
		    	System.out.print("Início da semana:"+w1.getStartTime());
				System.out.print(" Início da sessão:"+ w1.getStartSessionTime());
		    	System.out.println(" Tempo de estudo:"+w1.getStudyTime());
		    }
		},0,60000);
	}
}
