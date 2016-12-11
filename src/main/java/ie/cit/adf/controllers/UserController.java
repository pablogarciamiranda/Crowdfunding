package ie.cit.adf.controllers;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
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
			model.addObject("loginError", true);
		}
		if (logout != null) {
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		    if (auth != null){    
		        new SecurityContextLogoutHandler().logout(request, response, auth);
				model.addObject("logoutMessage", true);
		    }
		}

		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = "/sign_up", method = RequestMethod.GET)
	public String sign_up(Model model) 
	{
		model.addAttribute("user", new User());
		return "createUser";
	}
	
	@RequestMapping(value = "/sign_up", method = RequestMethod.POST)
	public String save_user(@Valid User user,
			BindingResult result,
			Model model) 
	{
		if (result.hasErrors()) {
			return "createUser";
		}
		user.setEnabled(true);
		userService.registerAccount(user);
		authorityService.registerAccount(new Authority(user.getUsername(), "ROLE_USER"));
		return "redirect:/login";
	}
	
	@RequestMapping(value = "/update_user", method = RequestMethod.GET)
	public String updateUser(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("name", name);
		User user = userService.getByUsername(name);
		model.addAttribute("user", user);
		
		return "updateUser";
		
	}
	
	@RequestMapping(value = "/update_user", method = RequestMethod.POST)
	public String saveUserUpdate(Model model,
			@ModelAttribute("SpringWeb") User userUpdated) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		model.addAttribute("name", name);
		User user = userService.getByUsername(name);
		user.setLocation(userUpdated.getLocation());
		user.setBiography(userUpdated.getBiography());
		user.setEmail(userUpdated.getEmail());
		userService.registerAccount(user);
		
		model.addAttribute("user", user);
		
		return "updateUser";
		
	}
	
	@RequestMapping(value = "/update_user/password", method = RequestMethod.GET)
	public String updatePassword(Model model) {
		return "updateUserPassword";
	}
	
	@RequestMapping(value = "/update_user/password", method = RequestMethod.POST)
	public String Password(Model model,
			@ModelAttribute("SpringWeb") User userUpdated) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String name = auth.getName();
		User user = userService.getByUsername(name);
		user.setPassword(userUpdated.getPassword());

		userService.registerAccount(user);
		
		return "updateUserPassword";
	}
}
