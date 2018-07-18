package com.booking.cinema.controller;

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

	@RequestMapping("/admin/users")
	public String showAllUsers(Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "admin/users";
	}

	@RequestMapping("/admin/users/{id}")
	public String getUserById(@PathVariable(value = "id") Long userId,
			Model model) {
		model.addAttribute("user",
				userRepository.findById(userId).orElseThrow(
						() -> new ResourceNotFoundException("User", "id",
								userId)));
		return "admin/user";
	}
}
