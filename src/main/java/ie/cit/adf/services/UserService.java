package ie.cit.adf.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import ie.cit.adf.domain.Project;
import ie.cit.adf.domain.User;
import ie.cit.adf.repositories.UserRepository;

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
	
//	public Collection<User> findOwners(Project project){
//		return userRepository.findAllByProject();
//	}
}