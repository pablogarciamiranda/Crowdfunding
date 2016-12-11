package ie.cit.adf.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import ie.cit.adf.domain.Category;
import ie.cit.adf.domain.Project;
import ie.cit.adf.domain.User;
import ie.cit.adf.services.CategoryService;
import ie.cit.adf.services.ProjectService;
import ie.cit.adf.services.UserService;

@Controller
public class ProjectController {
	
	
	@Autowired
	ProjectService projectService;
	
	@Autowired
	CategoryService categoryService;
	
	@Autowired
	UserService userService;

	
	@RequestMapping(value = "/add_project", method = RequestMethod.GET)
	public String addProject(Model model){
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("name", name);
		User user = userService.getByUsername(name);
		model.addAttribute("user", user);
		
		List<Category> categories = (List<Category>) categoryService.findAll();
		model.addAttribute("categories", categories);
		model.addAttribute("project", new Project());
		return "addProject";
	}
	
	@RequestMapping(value = "/show_projects", method = RequestMethod.POST)
	public String showProjectAdded(@Valid Project project,
			BindingResult result,
			Model model, @RequestParam(value = "myProjects",	required = false) boolean myProjects){

		if (result.hasErrors()) {
			return "addProject";
		}
		
		//Add the project to the current user of the system.
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("name", name);
		User user = userService.getByUsername(name);
		model.addAttribute("user", user);
		List<User> owners = new ArrayList<User>();
		owners.add(user);
		project.setOwners(owners);
		
		projectService.addProject(project);
		
		model.addAttribute("myProjects", myProjects);
		
		
		double credit = user.getCreditLimit();
		model.addAttribute("credit", credit);
		List<Project> projects = (List<Project>) projectService.findAll();
		model.addAttribute("projects", projects);
		List<Project> ownProjects = (List<Project>) projectService.findProjectsOwned(user);
		model.addAttribute("ownProjects", ownProjects);
		
		return "main";
	}

	
	@RequestMapping(value = "/update_project", method = RequestMethod.GET)
	public String updateProject(@RequestParam("id") int id, Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("name", name);
		User user = userService.getByUsername(name);
		model.addAttribute("user", user);
		
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
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("name", name);
		User user = userService.getByUsername(name);
		double credit = user.getCreditLimit();
		model.addAttribute("credit", credit);
		List<Project> projects = (List<Project>) projectService.findAll();
		model.addAttribute("projects", projects);
		List<Project> ownProjects = (List<Project>) projectService.findProjectsOwned(user);
		model.addAttribute("ownProjects", ownProjects);
		
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