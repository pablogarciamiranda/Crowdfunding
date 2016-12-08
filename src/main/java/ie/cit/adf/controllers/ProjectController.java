package ie.cit.adf.controllers;

import java.util.List;

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

import ie.cit.adf.domain.Category;
import ie.cit.adf.domain.Project;
import ie.cit.adf.services.CategoryService;
import ie.cit.adf.services.ProjectService;

@Controller
public class ProjectController {
	
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	CategoryService categoryService;
	
	@RequestMapping(value = "/add_project", method = RequestMethod.GET)
	public ModelAndView addProject(HttpServletRequest request,
							HttpServletResponse response){
		ModelAndView model = new ModelAndView();
		
		List<Category> categories = (List<Category>) categoryService.findAll();
		model.addObject("categories", categories);
		
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
		
		System.out.println(project + project.getCategory().getName());
		return model;
	}
	
	@RequestMapping(value = "/update_project", method = RequestMethod.GET)
	public String updateProject(@RequestParam("id") int id, Model model) {
		
		
		Project project = projectService.getById(id);
		model.addAttribute("project", project);
		model.addAttribute("id", id);
		
		List<Category> categories = (List<Category>) categoryService.findAll();
		model.addAttribute("categories", categories);
		
		return "updateProject";
		
	}
	
	@RequestMapping(value = "/update_project/{id}", method = RequestMethod.POST)
	public String saveUserUpdate(@PathVariable("id") int id, Model model,
			 Project projectUpdated) {
		
		Project project = projectService.getById(id);
		
		project.setName(projectUpdated.getName());
		project.setCategory(projectUpdated.getCategory());
		project.setLocation(projectUpdated.getLocation());
		project.setDescription(projectUpdated.getLocation());
		project.setFundingAmount(projectUpdated.getFundingAmount());
		project.setNumberOfDays(projectUpdated.getNumberOfDays());
		
		
		projectService.addProject(project);
		System.out.println(project + project.getCategory().getName());
		
		model.addAttribute("project", project);
		
		return "main";
	}
}
