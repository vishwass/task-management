package com.taskmgmt.persistence.repository;

import java.util.Optional;

import com.taskmgmt.persistence.model.Project;

public interface IProjectRepository {

	public Optional<Project> findById(long id);
	
	Project save(Project project);
}
