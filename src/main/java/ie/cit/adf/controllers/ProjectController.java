package ie.cit.adf.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import ie.cit.adf.domain.Project;
import ie.cit.adf.repositories.ProjectRepository;



@Controller
@RequestMapping("/project")
public class ProjectController {
	
	
	@Autowired
	ProjectRepository projectRepository;
	
	@RequestMapping("/add")
	public String addProject(Model model) {
		
		model.addAttribute(new Project());
		return "/project";
	}
	
	@RequestMapping(value="/add", method=RequestMethod.POST)
	public String processAddSubmit(@ModelAttribute("project") Project project, 
			BindingResult bindingResult) {
		
		//projectRepository.add(project)

		return "/main";
	}
	

}
