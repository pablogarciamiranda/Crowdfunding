package ie.cit.adf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ie.cit.adf.domain.Tag;

@Repository
public interface TagRepository extends CrudRepository<Tag, Integer> {

	//List<Tag> findAllByProject(Project project);

}
