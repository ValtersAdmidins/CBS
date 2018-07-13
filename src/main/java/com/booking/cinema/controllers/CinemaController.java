package com.booking.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.repositories.CinemaRepository;

@Controller
public class CinemaController {

	@Autowired
	CinemaRepository cinemaRepository;
	
	@RequestMapping("/cinemas")
    public String showAllMovies(Model model){
        model.addAttribute("cinemas", cinemaRepository.findAll());
        return "cinemas";
    }
	
	@RequestMapping("/cinemas/{id}")
    public String showAllMoviesinCinema(@PathVariable(value = "id") Long movieId, Model model){
        model.addAttribute("cinemas", cinemaRepository.findAll());
        return "cinemas";
    }
}
