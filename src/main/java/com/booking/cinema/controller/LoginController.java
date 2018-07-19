package com.booking.cinema.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.booking.cinema.model.User;
import com.booking.cinema.repositories.MovieRepository;
import com.booking.cinema.service.UserService;

@Controller
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@Autowired
	MovieRepository movieRepository;
	
//	@GetMapping("/movies/movie-create")
//	public String movieCreateForm(Model model) {
//		model.addAttribute("movie", new Movie());
//		return "movie";
//	}
	
	@RequestMapping(value="/registration", method = RequestMethod.GET)
	public ModelAndView registration(){
		ModelAndView modelAndView = new ModelAndView();
		User user = new User();
		modelAndView.addObject("user", user);
		modelAndView.setViewName("registration");
		return modelAndView;
	}
	
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid User user, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		User userExists = userService.findUserByEmail(user.getEmail());
		if (userExists != null) {
			bindingResult
					.rejectValue("email", "error.user",
							"There is already a user registered with the email provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			userService.saveUser(user);
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new User());
			modelAndView.addObject("movies", movieRepository.findAll());
			modelAndView.setViewName("index");
			
		}
		return modelAndView;
	}

}
