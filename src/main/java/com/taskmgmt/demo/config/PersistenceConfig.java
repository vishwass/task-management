package com.taskmgmt.demo.config;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.taskmgmt.persistence.repository.ProjectRepositoryImpl;
import com.taskmgmt.persistence.repository.ProjectRepositoryImpl2;

@Configuration
@EnableAutoConfiguration
//@ComponentScan(basePackages = "com.taskmgmt.demo")
@ComponentScan(basePackages = "com.taskmgmt")
public class PersistenceConfig {

//	@Bean(name = "projectRepositoryImpl",initMethod = "initialize", destroyMethod = "destroy")
//	public ProjectRepositoryImpl projectRepository() {
//		return new ProjectRepositoryImpl();
//	}
//	
//	@Bean(name = "projectRepositoryImpl2",initMethod = "initialize", destroyMethod = "destroy")
//	public ProjectRepositoryImpl2 projectRepository2() {
//		return new ProjectRepositoryImpl2();
//	}
}
