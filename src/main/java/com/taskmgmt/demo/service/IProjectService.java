package com.taskmgmt.demo.service;

import java.util.Optional;

import com.taskmgmt.persistence.model.Project;

public interface IProjectService {

	public Optional<Project> findById(long id);
	
	Project save(Project project);
}
