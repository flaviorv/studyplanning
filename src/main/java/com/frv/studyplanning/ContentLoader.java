package com.frv.studyplanning;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import com.frv.studyplanning.model.auxiliary.Constants;
import com.frv.studyplanning.model.domain.Content;

@Order(4)
@Component
public class ContentLoader implements ApplicationRunner{
	
	public void run(ApplicationArguments args) {
		System.out.println("Starting ContentLoader");	
		Content c1 = new Content();
		c1.setType(Constants.CONTENT_BOOK);
		c1.setDescription("Disciplined Agile Delivery");
		System.out.println(c1.getDesctiption());
		
		Content c2 = new Content();
		c2.setType(Constants.CONTENT_LINK);
		c2.setDescription("www.h2tutorial.com");
		System.out.println(c2.getDesctiption());
		
		Content  c3 = new Content();
		
		c3.setDescription("GRASP");
		c3.setType(Constants.CONTENT_KEYPOINT);
		System.out.println(c3.getDesctiption());
		
	}
}
