package com.taskmgmt.demo;

import java.time.LocalDate;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.taskmgmt.demo.config.PersistenceConfig;
import com.taskmgmt.demo.service.IProjectService;
import com.taskmgmt.persistence.model.Project;

@SpringBootApplication
public class LsApplication {

	public static void main(String[] args) {
		
		AnnotationConfigApplicationContext a = new AnnotationConfigApplicationContext(PersistenceConfig.class);
        //ConfigurableApplicationContext a = SpringApplication.run(LsApplication.class, args);
		//((AnnotationConfigApplicationContext) a).scan("com.taskmgmt.demo");
		IProjectService ps = a.getBean(IProjectService.class);
        System.out.println(ps.save(new Project(123L,"Test",LocalDate.now())));
        a.close();
	}

}
