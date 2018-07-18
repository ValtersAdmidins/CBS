package com.booking.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.repositories.ShowtimeRepository;

@Controller
public class ShowtimeController {
	
	@Autowired
	ShowtimeRepository showtimeRepository;
	
	
	@RequestMapping("/shotimes")
	public String showAllMovies(Model model) {
		model.addAttribute("showtimes", showtimeRepository.findAll());
		return "showtimes";
	}
	
	
	
}
