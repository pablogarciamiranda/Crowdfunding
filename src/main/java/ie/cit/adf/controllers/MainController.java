package ie.cit.adf.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ie.cit.adf.domain.Project;
import ie.cit.adf.domain.User;
import ie.cit.adf.services.ProjectService;
import ie.cit.adf.services.UserService;

@Controller
public class MainController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	ProjectService projectService;	
	
	@RequestMapping("/")
    public String main(Model model) {
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
		System.out.println("OWN PROJECTS!!!!!!!!!!!!!!!!1");
		for(Project p : ownProjects)
			System.out.println(p);
		System.out.println(" THE OTHER PROJECTS*************************");
		for(Project p : projects)
			System.out.println(p);
        return "main";
    }
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public ModelAndView login( @RequestParam(value = "error", required = false) String error,
							@RequestParam(value = "logout",	required = false) String logout,
							HttpServletRequest request,
							HttpServletResponse response) 
	
	{
		
		ModelAndView model = new ModelAndView();
		if (error != null) {
			model.addObject("error", "Invalid Credentials provided.");
		}
		if (logout != null) {
			model.addObject("message", "Logged out successfully.");
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
		    }
		}

		model.setViewName("login");
		return model;
	}

}
