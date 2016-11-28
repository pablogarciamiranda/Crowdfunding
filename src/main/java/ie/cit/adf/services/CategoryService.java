package ie.cit.adf.services;

import org.springframework.beans.factory.annotation.Autowired;

import ie.cit.adf.repositories.CategoryRepository;

public class CategoryService {
	
	@Autowired
	CategoryRepository categoryRepository;

}
