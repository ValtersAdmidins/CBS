package com.booking.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.repositories.UserRepository;

@Controller
public class UserController {

	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/users")
    public String showAllMovies(Model model){
        model.addAttribute("users", userRepository.findAll());
        return "index";
    }
}
