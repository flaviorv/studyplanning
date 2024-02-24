package com.frv.studyplanning;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.frv.studyplanning.model.domain.Course;
import com.frv.studyplanning.model.domain.Student;

@Order(2)
@Component
public class CourseLoader implements ApplicationRunner{
	
	public void run(ApplicationArguments args) {
		System.out.println("Starting CourseLoader");
		Course c = new Course();
		c.setName("Engenharia de Software");
		c.setStudent(new Student("Soraia Ramos", "sr@gmail.com", "321321"));
		
		System.out.println(c.toString());
		
		
	}
}
