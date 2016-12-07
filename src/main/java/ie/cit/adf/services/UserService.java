package ie.cit.adf.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.adf.domain.User;
import ie.cit.adf.repositories.UserRepository;

@Service
public class UserService {

	@Autowired
	UserRepository userRepository;

	public User registerAccount(User user){
		return userRepository.save(user);
	}
	
	public void deleteAccount(User user){
		userRepository.delete(user);
	}
	
	public boolean nameExists(String name){
		return userRepository.findByName(name) != null;
	}
	
	public boolean emailExists(String email){
		return userRepository.findByEmail(email) != null;
	}
	
	public Collection<User> findAll(){
		return (Collection<User>) userRepository.findAll();
	}
	
	public User getByUsername(String username) {
		return userRepository.findByUsername(username);
	}
	
//	public Collection<User> findOwners(Project project){
//		return userRepository.findAllByProject();
//	}
}