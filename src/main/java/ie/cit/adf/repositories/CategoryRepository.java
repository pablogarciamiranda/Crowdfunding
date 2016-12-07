package ie.cit.adf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ie.cit.adf.domain.Category;

@Repository
public interface CategoryRepository extends CrudRepository<Category, Integer> {


}
