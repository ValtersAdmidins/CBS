package com.booking.cinema.controller;

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
import com.booking.cinema.repository.CinemaRepository;

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
	public String showAllMoviesinCinema(
			@PathVariable(value = "id") Long cinemaID, Model model) {
		Optional<Cinema> cinema = cinemaRepository.findById(cinemaID);
		Set<Movie> movies = new HashSet<>();
		if (cinema.isPresent()) {
			movies = cinema.get().getMovies();
			model.addAttribute("cinema", cinema.get());
		}

		model.addAttribute("movies", movies);

		return "cinema";
	}

	// Loads the cinama-create html page.
	@GetMapping("/cinemas/cinema-create")
	public String cinemaCreatePage(Model model) {
		model.addAttribute("cinema", new Cinema());
		return "cinema-create";
	}

	// Proccesses the cinema creation and insertion into the database.
	@PostMapping("/cinemas/cinema-create")
	public String createCinemaProccess(Cinema cinema) {

		cinema.setLatitudeAndLongitudeFromAddress();
		cinemaRepository.save(cinema);
		return "redirect:/cinemas";
	}

}