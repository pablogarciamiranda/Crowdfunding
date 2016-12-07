package ie.cit.adf.repositories;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ie.cit.adf.domain.Project;
import ie.cit.adf.domain.User;

@Repository
public interface ProjectRepository extends CrudRepository<Project, Integer>{

	Collection<Project> findAllByOwners(User user);

	Project findById(int id);	

}
