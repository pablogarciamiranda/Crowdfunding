package ie.cit.adf.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import ie.cit.adf.domain.Project;
import ie.cit.adf.domain.Tag;

public interface TagRepository extends CrudRepository<Tag, Integer> {

	List<Tag> findAllByProject(Project project);

}
