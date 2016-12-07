package ie.cit.adf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ie.cit.adf.domain.Pledge;

@Repository
public interface PledgeRepository extends CrudRepository<Pledge, Integer>{

	
}
