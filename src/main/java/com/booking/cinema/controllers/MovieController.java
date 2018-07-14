package com.booking.cinema.controllers;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.exceptions.ResourceNotFoundException;
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
	/*
	 * // Create a new Movie
	 * 
	 * @PostMapping("/movies/create") public Movie createMovie(@Valid @RequestBody
	 * Movie movie) { return movieRepository.save(movie); }
	 * 
	 * 
	 * 
	 * // Update a Movie
	 * 
	 * @PutMapping("/movies/{id}") public Movie updateMovie(@PathVariable(value =
	 * "id") Long movieId, @Valid @RequestBody Movie movieDetails) {
	 * 
	 * Movie movie = movieRepository.findById(movieId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Movie", "id", movieId));
	 * 
	 * movie.setTitle(movieDetails.getTitle());
	 * movie.setPlot(movieDetails.getPlot());
	 * 
	 * Movie updatedMovie = movieRepository.save(movie); return updatedMovie; }
	 * 
	 * // Delete a Movie
	 * 
	 * @DeleteMapping("/movies/{id}") public ResponseEntity<?>
	 * deleteMovie(@PathVariable(value = "id") Long movieId) { Movie movie =
	 * movieRepository.findById(movieId) .orElseThrow(() -> new
	 * ResourceNotFoundException("Movie", "id", movieId));
	 * 
	 * movieRepository.delete(movie);
	 * 
	 * return ResponseEntity.ok().build(); }
	 * 
	 * // View sample movie
	 * 
	 * @GetMapping(path = "/movies/sample") public String viewSampleMovie(Model
	 * model) {
	 * 
	 * Movie movie = new Movie(); model.addAttribute("title", movie.getTitle());
	 * AgeLimit al = movie.getAgeLimit(); switch (al) { case NOLIMIT:
	 * model.addAttribute("ageLimit", "U"); break; case PLUSEIGHTTEEN:
	 * model.addAttribute("ageLimit", "+18"); break; case PLUSSIXTEEN:
	 * model.addAttribute("ageLimit", "+16"); break; }
	 * 
	 * model.addAttribute("genres", movie.getGenres()); model.addAttribute("lang",
	 * movie.getLanguage()); model.addAttribute("subs", movie.getSubtitles());
	 * model.addAttribute("length", movie.getMovieLength());
	 * 
	 * return "displaymovie"; }
	 */
}