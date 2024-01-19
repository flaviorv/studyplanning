package com.frv.studyplanning;

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
		s1.countHours(); 
		System.out.println("Nome da Matéria: "+s1.getName()+
				"\nDia de Início: "+s1.getStartDay()+
				"\nHora de Início: "+s1.getStartHour());
	}

}
