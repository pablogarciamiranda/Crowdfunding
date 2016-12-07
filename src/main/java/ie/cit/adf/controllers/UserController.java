package ie.cit.adf.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import ie.cit.adf.domain.Authority;
import ie.cit.adf.domain.User;
import ie.cit.adf.services.AuthorityService;
import ie.cit.adf.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	AuthorityService authorityService;

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
	
	@RequestMapping(value = "/sign_up", method = RequestMethod.GET)
	public ModelAndView sign_up(HttpServletRequest request,
							HttpServletResponse response) 
	{
		ModelAndView model = new ModelAndView();
		model.setViewName("createUser");
		return model;
	}
	
	@RequestMapping(value = "/sign_up_success", method = RequestMethod.POST)
	public ModelAndView save_user(@ModelAttribute("SpringWeb") User user,
							HttpServletRequest request,
							HttpServletResponse response) 
	{
		user.setEnabled(true);
		userService.registerAccount(user);
		authorityService.registerAccount(new Authority(user.getUsername(), "ROLE_USER"));
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
}
