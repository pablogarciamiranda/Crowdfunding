package ie.cit.adf.services;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.cit.adf.domain.Tag;
import ie.cit.adf.repositories.TagRepository;

@Service
public class TagService {
	
	@Autowired
	TagRepository tagRepository;

	public Collection<Tag> findAll(){
		return (Collection<Tag>) tagRepository.findAll();
	}
	
//	public Collection<Tag> findAllByProject(Project project){
//		return tagRepository.findAllByProject(project);
//		
//	}
}
