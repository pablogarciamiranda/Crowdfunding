package ie.cit.adf.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ie.cit.adf.domain.Reward;

@Repository
public interface RewardRepository extends CrudRepository<Reward, Integer> {

}
