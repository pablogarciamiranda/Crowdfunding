package ie.cit.adf.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.adf.domain.Project;
import ie.cit.adf.domain.User;
import ie.cit.adf.repositories.ProjectRepository;

@Service
public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
	
	public Collection<Project> findAll(){
		return (Collection<Project>) projectRepository.findAll();
	}
	
	public Collection<Project> findProjectsOwned(User user){
		return projectRepository.findAllByOwners(user);
	}
	
}
