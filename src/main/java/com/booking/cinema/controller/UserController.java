package com.booking.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.model.Movie;
import com.booking.cinema.model.User;
import com.booking.cinema.repositories.UserRepository;
import com.booking.cinema.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@Autowired
	UserService userService;

	@RequestMapping("/admin/users")
	public String showAllUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "admin/users";
	}

	@RequestMapping("/admin/users/{id}")
	public String getUserById(@PathVariable(value = "id") Long userId,
			Model model) {
		model.addAttribute("user", userRepository.findById(userId).orElseThrow(
				() -> new ResourceNotFoundException("User", "id", userId)));
		return "admin/user";
	}

	 
//	@RequestMapping("/userProfile")
//	public String getUserProfile(Model model) {
//		
//		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
//	
//	    User u = userService.getUser(userDetail.getUsername());
//	    request.getSession().setAttribute("userId", u.getId());
//		
//		
//		model.addAttribute("user", userRepository.findById(userId).orElseThrow(
//						() -> new ResourceNotFoundException("User", "id",
//								userId)));
//		return "userprofile";
//	}
	
//	Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//    UserDetails userDetail = (UserDetails) auth.getPrincipal();
//
//    User u = userService.getUser(userDetail.getUsername());
//    request.getSession().setAttribute("userId", u.getId());


//	@RequestMapping(value = "/userProfile", method = RequestMethod.GET)
//	public String movieEditForm(@RequestParam(name = "userId") Long userId,
//			Model model) {
//
//		User user = userRepository.findById(userId).orElseThrow(
//				() -> new ResourceNotFoundException("User", "id", userId));
//
//		model.addAttribute(user);
//		return "userProfile";
//	}
	
	@RequestMapping("/userProfile")
	public String showAllMovies(Model model) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
	    UserDetails userDetail = (UserDetails) auth.getPrincipal();
	    
	    User user = userService.findUserByEmail(userDetail.getUsername());
		model.addAttribute("user", user);
		
		return "userProfile";
	}
	
}
