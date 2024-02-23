package com.frv.studyplanning;

import java.util.Timer;
import java.util.TimerTask;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.frv.studyplanning.model.domain.Week;

@Order(5)
@Component
public class WeekLoader implements ApplicationRunner{
	
	public void run(ApplicationArguments args) {
		System.out.println("Starting WeekLoader");
		Week w1 = new Week();
		w1.setStartSessionTime();
		new Timer().scheduleAtFixedRate(new TimerTask(){
			private Integer iterations = 0;
			@Override
			public void run(){
				if(iterations == 3) {
					iterations = 0;
					w1.setStartSessionTime();
				}
				System.out.println("Session will restart in "+(3-iterations)+" iterations");
				//setStartTime is only altered if null(what sholdn't occur)
		    	w1.setStartTime();
		    	w1.calculateStudyTime(w1.getStartSessionTime());
		    	System.out.println("Início da semana: "+w1.getStartTime());
				System.out.println("Início da sessão: "+ w1.getStartSessionTime());
		    	System.out.println(" - Tempo de estudo: "+w1.getStudyTime());
		    	iterations++;
		    }
		},0,60000);
	}
}
