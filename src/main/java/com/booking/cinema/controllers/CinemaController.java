package com.booking.cinema.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.model.Cinema;
import com.booking.cinema.model.Movie;
import com.booking.cinema.repositories.CinemaRepository;

@Controller

public class CinemaController {

	@Autowired
	CinemaRepository cinemaRepository;

	@RequestMapping("/cinemas")
	public String showAllMovies(Model model) {
		model.addAttribute("cinemas", cinemaRepository.findAll());
		return "cinemas";
	}

	@RequestMapping("/cinemas/{id}")
	public String showAllMoviesinCinema(@PathVariable(value = "id") Long cinemaID, Model model) {
		Optional<Cinema> cin = cinemaRepository.findById(cinemaID);
		Set<Movie> mov = new HashSet<>();
		if (cin.isPresent()) {
			mov = cin.get().getMovies();
			model.addAttribute("cinema", cin.get());
		}

		model.addAttribute("movies", mov);

		return "cinema";
	}

	@GetMapping("/cinemas/cinema-create")
	public String cinemaCreatePage(Model model) {
		model.addAttribute("cinema", new Cinema());
		return "cinema-create";
	}
	
	// Create a new Cinema
	@PostMapping("/cinemas/cinema-create")
	public String createCinemaProccess(Cinema cinema) {

		cinema.setLatitude(120);
		cinema.setLongitude(80);
		
		//cinema.setLatitudeAndLongitudeFromAddress();
		cinemaRepository.save(cinema);
		return "redirect:/cinemas";
	}
}