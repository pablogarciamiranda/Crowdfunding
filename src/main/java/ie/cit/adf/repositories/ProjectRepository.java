package ie.cit.adf.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

import ie.cit.adf.domain.Project;
import ie.cit.adf.domain.User;

public interface ProjectRepository extends CrudRepository<Project, Integer>{

	Collection<Project> findAllByUser(User user);
	
	

}
