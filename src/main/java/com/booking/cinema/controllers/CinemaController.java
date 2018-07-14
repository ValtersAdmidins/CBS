package com.booking.cinema.controllers;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@RequestMapping("/cinema/{id}")
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

	// Create a new Cinema
	@PostMapping("/cinemas/cinema-create/cinemaCreateProccess")
	public Cinema createCinemaProccess(@Valid @RequestBody Cinema cinema) {

		
		
		return cinemaRepository.save(cinema);
	}
}