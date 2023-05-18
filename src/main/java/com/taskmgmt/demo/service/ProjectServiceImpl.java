package com.taskmgmt.demo.service;

import java.util.Optional;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.taskmgmt.persistence.model.Project;
import com.taskmgmt.persistence.repository.IProjectRepository;

import jakarta.annotation.PostConstruct;
@Service
//@Lazy
public class ProjectServiceImpl implements IProjectService {

	
	private org.slf4j.Logger l = LoggerFactory.getLogger(ProjectServiceImpl.class);
	
	private IProjectRepository iProjectRepository;
	//private IProjectRepository iProjectRepository2;

	

	public IProjectRepository getiProjectRepository() {
		return iProjectRepository;
	}

//setter injection
	@Autowired
	public void setiProjectRepository( IProjectRepository iProjectRepository) {
			this.iProjectRepository = iProjectRepository;
		}



// constructor injection	
//	@Autowired
//	public ProjectServiceImpl( @Qualifier("projectRepositoryImpl2")IProjectRepository iProjectRepository) {
//		super();
//		this.iProjectRepository = iProjectRepository;
//	}
	
	
//Bean type prototype test	
//	public IProjectRepository getiProjectRepository2() {
//		return iProjectRepository2;
//	}
//
//	@Autowired
//	public void setiProjectRepository2(IProjectRepository iProjectRepository2) {
//		this.iProjectRepository2 = iProjectRepository2;
//	}

	@PostConstruct
	public void post() {
		l.info("PostConstruct iProjectService class: iProjectRepository class type injected during initialization: " + iProjectRepository);
		//l.info("PostConstruct iProjectService class: iProjectRepository2 class type injected during initialization: " + iProjectRepository2);

	}
	



	@Override
	public Optional<Project> findById(long id) {
		return iProjectRepository.findById(id);
	}

	@Override
	public Project save(Project project) {
		return iProjectRepository.save(project);
	}

}
