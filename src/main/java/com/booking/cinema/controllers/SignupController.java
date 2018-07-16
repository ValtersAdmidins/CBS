package com.booking.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.booking.cinema.model.Cinema;
import com.booking.cinema.model.User;
import com.booking.cinema.repositories.UserRepository;

@Controller
public class SignupController {

	@Autowired
	UserRepository userRepository;
	
	// Loads the signup html page.
	@GetMapping("/signup")
	public String signupPage(Model model) {
		model.addAttribute("user", new User());
		return "signup";
	}

	// Proccesses the movie creation and insertion into the database.
	@PostMapping("/signup")
	public String signupProccess(User user) {
		userRepository.save(user);
		return "redirect:/";
	}
	
}