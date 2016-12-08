package ie.cit.adf.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import ie.cit.adf.domain.Project;
import ie.cit.adf.services.ProjectService;

@Controller
public class ProjectController {
	
	
	@Autowired
	ProjectService projectService;
	
	@RequestMapping(value = "/add_project", method = RequestMethod.GET)
	public ModelAndView addProject(HttpServletRequest request,
							HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		model.setViewName("addProject");
		return model;
	}
	
	@RequestMapping(value = "/show_projects", method = RequestMethod.POST)
	public ModelAndView showProjectAdded(@ModelAttribute Project project,
							HttpServletRequest request,
							HttpServletResponse response){

		projectService.addProject(project);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("main");
		
		System.out.println(project);
		return model;
	}
	
	@RequestMapping(value = "/update_project", method = RequestMethod.GET)
	public String updateProject(@RequestParam("id") int id, Model model) {
		
		
		Project project = projectService.getById(id);
		model.addAttribute("project", project);
		model.addAttribute("id",id);
		
		return "updateProject";
		
	}
	
	@RequestMapping(value = "/update_project/{id}", method = RequestMethod.POST)
	public String saveUserUpdate(@PathVariable("id") int id, Model model,
			 Project projectUpdated) {
		
		Project project = projectService.getById(id);
		
		project.setName(projectUpdated.getName());
		project.setLocation(projectUpdated.getLocation());
		project.setDescription(projectUpdated.getLocation());
		project.setFundingAmount(projectUpdated.getFundingAmount());
		project.setNumberOfDays(projectUpdated.getNumberOfDays());
		
		projectService.addProject(project);
		
		model.addAttribute("project", project);
		
		return "main";
	}
}
