package com.booking.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.repositories.ShowtimeRepository;

@Controller
public class ShowtimeController {

	@Autowired
	ShowtimeRepository showtimeRepository;

	@RequestMapping("/showtimes")
	public String showAllShowtimes(Model model) {
		model.addAttribute("showtimes", showtimeRepository.findAll());
		return "showtimes";
	}

	@RequestMapping("/showtimes/{id}")
	public String getShowtimeById(@PathVariable(value = "id") Long showtimeId, Model model) {
		model.addAttribute("showtime", showtimeRepository.findById(showtimeId)
				.orElseThrow(() -> new ResourceNotFoundException("Showtime", "id", showtimeId)));
		return "showtime";
	}
}