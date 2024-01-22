package com.frv.studyplanning;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.frv.studyplanning.model.domain.Subject;

@Order(2)
@Component
public class SubjectLoader implements ApplicationRunner {
	
	@Override
	public void run(ApplicationArguments args) {
		
		System.out.println("Initialing SubjectLoader");
		
		Subject s1 = new Subject("Disciplined Agile Delivery");
		System.out.println("Nome da Matéria: "+s1.getName()+
				"\nDia de Início: "+s1.getStartDay());
		s1.setStartOfStudyMilleseconds();
		s1.calculateStudyMinutes();
		System.out.println("studyMinutes " + s1.getStudyMinutes());
		
		new Timer().scheduleAtFixedRate(new TimerTask() {
		   
			@Override
			public void run() {
			
				Subject s2 = new Subject("Refatoração");
				System.out.println("Nome da Matéria: "+s2.getName()+
						"\nDia de Início: "+s2.getStartDay());
				s1.calculateStudyMinutes();
				System.out.println("studyMinutes " + s1.getStudyMinutes());
		   }
		}, 60000, 60000);    
		
		System.out.println("Finishing SubjectLoader");
	}	
}
