package com.frv.studyplanning;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.frv.studyplanning.model.domain.Student;

@Order(1)
@Component
public class StudentLoader implements ApplicationRunner{
	
	public void run(ApplicationArguments args) {
//		
//		System.out.println("Starting StudentLoader");	
//		Student s1 = new Student("Amanda Nogueira", "an@outlook", "123456");
//		Student s2 = new Student("João Carlos", "jc@gmail.com", "123");
//		Student s3 = new Student("Soraia Ramos", "sr@gmail.com", "321321");
//		
//		s1.toString();
//		s2.toString();
//		s3.toString();
		
	}
}
