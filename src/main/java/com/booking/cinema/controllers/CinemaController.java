package com.booking.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.repositories.CinemaRepository;

@Controller
public class CinemaController {

	@Autowired
	CinemaRepository cinemaRepository;
	
	@RequestMapping("/cinemas")
    public String showAllCinemas(Model model){
        model.addAttribute("cinemas", cinemaRepository.findAll());
        return "cinemas";
    }
	
	@RequestMapping("/cinemas/{id}")
	public String getCinemaById(@PathVariable(value = "id") Long cinemaId, Model model) {
		model.addAttribute("cinema", cinemaRepository.findById(cinemaId)
				.orElseThrow(() -> new ResourceNotFoundException("Cinema", "id", cinemaId)));
		return "cinema";
	}
}