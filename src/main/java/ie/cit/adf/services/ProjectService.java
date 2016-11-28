package ie.cit.adf.services;

import org.springframework.beans.factory.annotation.Autowired;

import ie.cit.adf.repositories.ProjectRepository;

public class ProjectService {

	@Autowired
	ProjectRepository projectRepository;
}
