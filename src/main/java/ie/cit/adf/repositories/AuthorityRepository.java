package ie.cit.adf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ie.cit.adf.domain.Authority;

@Repository
public interface AuthorityRepository extends CrudRepository<Authority, Integer> {

}