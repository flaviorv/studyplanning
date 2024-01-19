package com.frv.studyplanning;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import com.frv.studyplanning.model.domain.Subject;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class StudyplanningApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudyplanningApplication.class, args);
		System.out.println("Running sucefully");
		Subject s1 = new Subject("materiaTeste");
		System.out.println("Nome da Matéria: "+s1.getName()+
				"\nDia de Início: "+s1.getStartDay()+
				"\nHora de Início: "+s1.getStartHour());
		
	   new Timer().schedule(new TimerTask() {
		   @Override
		   public void run() {
			   Subject s2 = new Subject("materiaTeste 2");
				System.out.println("Nome da Matéria: "+s2.getName()+
						"\nDia de Início: "+s2.getStartDay()+
						"\nHora de Início: "+s2.getStartHour());

		   }
	   }, 5000);      
		
	}

}
