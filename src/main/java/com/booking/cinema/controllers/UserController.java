package com.booking.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;

	@RequestMapping("/users")
	public String showAllUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "users";
	}

	// Get a Single User
	@RequestMapping("/users/{id}")
	public String getUserById(@PathVariable(value = "id") Long userId, Model model) {
		model.addAttribute("user", userRepository.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User", "id", userId)));
		return "user";
	}

}