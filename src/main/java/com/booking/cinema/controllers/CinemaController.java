package com.booking.cinema.controllers;

import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.model.Cinema;
import com.booking.cinema.model.Movie;
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
    public String showAllMoviesinCinema(@PathVariable(value = "id") Long cinemaID, Model model){
        Optional<Cinema> cin = cinemaRepository.findById(cinemaID);
        if(cin.isPresent()) {
        	Set<Movie> mov = cin.get().getMovies();
        	model.addAttribute("movies",mov);
        }
        
        model.addAttribute("cinema",cinemaRepository.findById(cinemaID));
        
		
        return "cinemas";
    }
}