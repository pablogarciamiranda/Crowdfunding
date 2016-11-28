package ie.cit.adf.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ie.cit.adf.domain.User;

@Repository
public interface UserRepository extends CrudRepository <User,Integer> {
	
	User findByName(String name);
	User findByEmail(String email);
	List<User> findAllByProject();

}
