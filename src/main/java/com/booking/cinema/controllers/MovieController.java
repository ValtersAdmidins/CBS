package com.booking.cinema.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.booking.cinema.enums.AgeLimit;
import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.model.Movie;
import com.booking.cinema.repositories.MovieRepository;

@Controller
public class MovieController {

	@Autowired
	MovieRepository movieRepository;

	@RequestMapping("/")
	public String showAllMovies(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		return "index";
	}

	// Get a Single Movie
	@RequestMapping("/movies/{id}")
	public String getMovieById(@PathVariable(value = "id") Long movieId, Model model) {
		model.addAttribute("movie", movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId)));
		return "movie";
	}

	// Create a new Movie
	@PostMapping("/movies/addMovie")
	public Movie createMovie(@Valid @RequestBody Movie movie) {

		return movieRepository.save(movie);
	}

	// Update a Movie
	@PutMapping("/movies/{id}")
	public Movie updateMovie(@PathVariable(value = "id") Long movieId, @Valid @RequestBody Movie movieDetails) {

		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

		movie.setTitle(movieDetails.getTitle());
		movie.setPlot(movieDetails.getPlot());

		Movie updatedMovie = movieRepository.save(movie);
		return updatedMovie;
	}

	// Delete a Movie
	@DeleteMapping("/movies/{id}")
	public ResponseEntity<?> deleteMovie(@PathVariable(value = "id") Long movieId) {
		Movie movie = movieRepository.findById(movieId)
				.orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

		movieRepository.delete(movie);

		return ResponseEntity.ok().build();
	}

}
