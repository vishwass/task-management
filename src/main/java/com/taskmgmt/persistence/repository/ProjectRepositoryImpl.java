package com.taskmgmt.persistence.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.taskmgmt.persistence.model.Project;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component(value = "projectRepositoryImpl")
//@Repository(value = "projectRepositoryImpl")
//@Primary
public class ProjectRepositoryImpl implements IProjectRepository{

	List<Project> projects = new ArrayList<>();
	
	
	
	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

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
		System.out.println("Postconstruct: ProjectRepositoryImpl.class, projects currently in repository:" +projects.stream().findFirst());
	}
	
	@Override
	public Project save(Project project) {
		Project existingProject = findById(project.getId()).orElse(null);
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
		System.out.println("Predestroy: ProjectRepositoryImpl.class");
	}
	
	public void destroy() {
		System.out.println("Destroy method: Destroying ProjectRepositoryImpl.class instance. Persistence used: In Memory List.");
	}
	

}
