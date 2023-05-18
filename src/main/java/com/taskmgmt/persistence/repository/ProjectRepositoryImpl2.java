package com.taskmgmt.persistence.repository;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.taskmgmt.persistence.model.Project;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component(value ="projectRepositoryImpl2")
@Primary
@Scope("prototype")
//@Repository(value="projectRepositoryImpl2")
public class ProjectRepositoryImpl2 implements IProjectRepository{

//	
//	@Value("${project.prefix}")
//	private String prefix;
//	@Value("${project.suffix}")
//	private int suffix;
	List<Project> projects = new LinkedList<>();
	
	@Override
	public Optional<Project> findById(long id) {
		return projects.stream().filter(p -> p.getId() == id).findFirst();
	}

	public void initialize() {
		System.out.println("Initialize method. Persistence used: In Memory List.");
	}
	
	@PostConstruct
	public void post() {
		//Note @Postconstruct and initialize are same thing defined  in a different way.
		System.out.println("Postconstruct: ProjectRepositoryImpl2.class");
	}
	
	@Override
	public Project save(Project project) {
		Project existingProject = findById(project.getId()).orElse(null);
		//updateInternalID(project);
		if(existingProject == null) {
			projects.add(project);
			return project;
		}else {
			projects.remove(project);
			Project np = new Project(project);
			projects.add(np);
			return project;
			
		}
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("Predestroy: ProjectRepositoryImpl2.class");
	}
	
	public void destroy() {
		System.out.println("Destroy method: Destroying ProjectRepositoryImpl2.class instance. Persistence used: In Memory List.");
	}
//	
//	private void updateInternalID(Project p) {
//		p.setInternalID( this.prefix + p.getId() + this.suffix);
//	}
//
//	public String getPrefix() {
//		return prefix;
//	}
//
//	public int getSuffix() {
//		return suffix;
//	}
//
//	public void setPrefix(String prefix) {
//		this.prefix = prefix;
//	}
//
//	public void setSuffix(int suffix) {
//		this.suffix = suffix;
//	}
	

}
