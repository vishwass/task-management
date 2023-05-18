package com.taskmgmt.demo.extensions;

import java.time.LocalDate;
import java.util.HashSet;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.stereotype.Component;

import com.taskmgmt.persistence.model.Project;



@Component
public class MyBeanFactoryPostPocessor implements BeanFactoryPostProcessor {

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		BeanDefinition bd = beanFactory.getBeanDefinition("projectRepositoryImpl");
		HashSet<Project> projects = new HashSet<>();
		Project p = new Project(1L, "Main task", LocalDate.now());
		projects.add(p);
		bd.getPropertyValues().add("projects",p );

	}

}
