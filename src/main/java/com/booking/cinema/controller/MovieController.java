package com.booking.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.model.Movie;
import com.booking.cinema.model.User;
import com.booking.cinema.repositories.MovieRepository;
import com.booking.cinema.repositories.UserRepository;


@Controller
public class MovieController {

	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	UserRepository userRepository;

	@RequestMapping("/")
	public String showAllMovies(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		return "index";
	}

	@RequestMapping("/movies/{id}")
	public String getMovieById(@PathVariable(value = "id") Long movieId,
			Model model) {
		model.addAttribute("movie",
				movieRepository.findById(movieId).orElseThrow(
						() -> new ResourceNotFoundException("Movie", "id",
								movieId)));
		return "movie";
	}
	
	// Loads the movie-create html page for admin.
	@RequestMapping(value="/movies/movie-create", method = RequestMethod.GET)
	public ModelAndView movieCreatePage(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userRepository.findByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/movie-create");
		return modelAndView;
	}
	
	@RequestMapping(value = "/movies/movie-create", method = RequestMethod.POST)
	public ModelAndView createNewUser(Movie movie) {
		ModelAndView modelAndView = new ModelAndView();
		movieRepository.save(movie);
		modelAndView.setViewName("/");
		return modelAndView;
	}
	
	
//	// PROCCESS
//		@RequestMapping(value="/movies/movie-create", method = RequestMethod.POST)
//		public ModelAndView movieCreateProccess(Movie movie){
//			ModelAndView modelAndView = new ModelAndView();
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			User user = userService.findUserByEmail(auth.getName());
//			modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//			modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//			modelAndView.setViewName("/");
//			movieRepository.save(movie);
//			return modelAndView;
//		}
	
	
	
//	// Proccesses the movie creation and insertion into the database.
//	@PostMapping("/movies/movie-create")
//	public String createMovieProccess(Movie movie) {
//
//		movieRepository.save(movie);
//		return "redirect:/";
//	}
	
	// Loads the movie-create html page for admin.
//		@RequestMapping(value="/admin/movies/movie-create", method = RequestMethod.POST)
//		public ModelAndView movieCreateProccess(Movie movie){
//			ModelAndView modelAndView = new ModelAndView();
//			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//			User user = userService.findUserByEmail(auth.getName());
//			modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
//			modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
//			modelAndView.setViewName("admin/home");
//			return modelAndView;
//		}
		
		
	
//	@RequestMapping(value={"/admin/movies/movie-create"}, method = RequestMethod.GET)
//	public ModelAndView movieCreatePage(){
//		ModelAndView modelAndView = new ModelAndView();
//		modelAndView.setViewName("movie");
//		return modelAndView;
//	}

//	// Proccesses the movie creation and insertion into the database.
//	@PostMapping("/admin/movies/movie-create")
//	public String createMovieProccess(Movie movie) {
//
//		movieRepository.save(movie);
//		return "redirect:/admin/home";
//	}
	
	
	/*
	 * // Update a Movie
	 * 
	 * @PutMapping("/movies/{id}") public Movie updateMovie(@PathVariable(value
	 * = "id") Long movieId, @Valid @RequestBody Movie movieDetails) {
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
	 * deleteMovie(@PathVariable(value = "id") Long movieId) {
	 * 
	 * Movie movie = movieRepository.findById(movieId) .orElseThrow(() -> new
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
	 * model.addAttribute("genres", movie.getGenres());
	 * model.addAttribute("lang", movie.getLanguage());
	 * model.addAttribute("subs", movie.getSubtitles());
	 * model.addAttribute("length", movie.getMovieLength());
	 * 
	 * return "displaymovie"; }
	 */
}