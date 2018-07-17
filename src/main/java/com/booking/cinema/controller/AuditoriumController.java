package com.booking.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.booking.cinema.model.Auditorium;
import com.booking.cinema.repository.AuditoriumRepository;
import com.booking.cinema.repository.CinemaRepository;

@Controller
public class AuditoriumController {

	@Autowired
	CinemaRepository cinemaRepository;
	
	@Autowired
	AuditoriumRepository auditoriumRepository;

	// Loads the auditorium-create html page.
	@GetMapping("/cinemas/auditorium-create")
	public String cinemaCreatePage(Model model) {
		model.addAttribute("auditorium", new Auditorium());
		return "auditorium-create";
	}

}