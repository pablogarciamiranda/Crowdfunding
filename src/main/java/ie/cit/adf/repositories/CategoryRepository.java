package ie.cit.adf.repositories;

import org.springframework.data.repository.CrudRepository;

import ie.cit.adf.domain.Category;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

}
