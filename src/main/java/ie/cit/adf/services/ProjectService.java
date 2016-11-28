package ie.cit.adf.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;

import ie.cit.adf.domain.Project;
import ie.cit.adf.domain.User;
import ie.cit.adf.repositories.ProjectRepository;

public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	public Collection<Project> findAll(){
		return (Collection<Project>) projectRepository.findAll();
	}
	
	public Collection<Project> findProjectsOwned(User user){
		return projectRepository.findAllByUser(user);
	}
	
}
