package ie.cit.adf.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.adf.domain.Category;
import ie.cit.adf.repositories.CategoryRepository;

@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;
	
	public Collection<Category> findAll(){
		return (Collection<Category>) categoryRepository.findAll();
	}


}
