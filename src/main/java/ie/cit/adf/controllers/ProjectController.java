package ie.cit.adf.controllers;

import java.math.BigDecimal;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

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
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ModelAndView showProjectAdded(@ModelAttribute Project project,
							HttpServletRequest request,
							HttpServletResponse response, @RequestParam(value = "myProjects",	required = false) boolean myProjects){

		projectService.addProject(project);
		
		ModelAndView model = new ModelAndView();
		model.setViewName("main");
		model.addObject("myProjects", myProjects);
		
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
			 Project projectUpdated, @RequestParam(value = "myProjects", required = false) boolean myProjects) {
		
		Project project = projectService.getById(id);
		
		project.setName(projectUpdated.getName());
		project.setCategory(projectUpdated.getCategory());
		project.setLocation(projectUpdated.getLocation());
		project.setDescription(projectUpdated.getLocation());
		project.setFundingAmount(projectUpdated.getFundingAmount());
		project.setNumberOfDays(projectUpdated.getNumberOfDays());
		
		projectService.addProject(project);
		
		model.addAttribute("project", project);
		model.addAttribute("myProjects", myProjects);
		
		return "main";
	}
	
	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public String showProject(@PathVariable("id") int id, Model model) {
		
		Project project = projectService.getById(id);		
		model.addAttribute("project", project);
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("name", name);
		
		BigDecimal percentage = new BigDecimal(project.getCurrentAmount()*100/project.getFundingAmount());
		model.addAttribute("percentage", percentage.intValue());
		
		return "project";
	}
	
	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public View showProjects(Model model) {	
		
		return new RedirectView("/");
	}
}