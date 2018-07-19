package com.booking.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.model.Cinema;
import com.booking.cinema.model.Movie;
<<<<<<< HEAD
import com.booking.cinema.model.Showtime;
=======
import com.booking.cinema.repositories.CinemaRepository;
>>>>>>> 6ab59e42298e1566d803e4742139625b56a93e88
import com.booking.cinema.repositories.MovieRepository;
import com.booking.cinema.repositories.ShowtimeRepository;
import com.booking.cinema.repositories.UserRepository;
import com.booking.cinema.service.UserService;

@Controller
public class MovieController {

	@Autowired
	CinemaRepository cinemaRepository;

	@Autowired
	MovieRepository movieRepository;

	@Autowired
	UserRepository userRepository;

	@Autowired
	ShowtimeRepository showtimeRepository;

	@Autowired
	UserService userService;

	@RequestMapping("/")
	public String showAllMovies(Model model) {
		model.addAttribute("movies", movieRepository.findAll());
		return "index";
	}

	@RequestMapping("/movies/{movieId}")
	public String getMovieById(@PathVariable(value = "movieId") Long movieId,
			Model model) {
		model.addAttribute("movie",
				movieRepository.findById(movieId).orElseThrow(
						() -> new ResourceNotFoundException("Movie", "id",
								movieId)));
		
		model.addAttribute("showtimes",showtimeRepository.findAllShowtimesForMovie(movieId));
		System.out.println("IZPILDAS FIND ALL SHOWTIMES FOR MOVIE");
		for(Showtime s : showtimeRepository.findAllShowtimesForMovie(movieId)) {
			System.out.println(s);
		}
		return "movie";
	}

	@RequestMapping(value = "/movies/{movieId}/cinemas", method = RequestMethod.GET)
	public String ticketBuyForm(@PathVariable(value = "movieId") Long movieId,
			Model model) {

		Movie movie = movieRepository.findById(movieId).orElseThrow(
				() -> new ResourceNotFoundException("Movie", "id", movieId));

		model.addAttribute("movie", movie);
		model.addAttribute("cinemas", cinemaRepository.findAll());

		return "chooseCinema";
	}
	
	@RequestMapping(value = "/movies/{movieId}/cinemas/{cinemaId}", method = RequestMethod.GET)
	public String ticketBuyForm(@PathVariable(value = "movieId") Long movieId, @PathVariable(value = "cinemaId") Long cinemaId,
			Model model) {

		Movie movie = movieRepository.findById(movieId).orElseThrow(
				() -> new ResourceNotFoundException("Movie", "id", movieId));

		Cinema cinema = cinemaRepository.findById(cinemaId).orElseThrow(
				() -> new ResourceNotFoundException("Cinema", "id", cinemaId));
		
		model.addAttribute("movie", movie);
		model.addAttribute("cinema", cinema);

		return "showtimes";
	}
	
//	@RequestMapping(value = "/movies/{movieId}/cinemas/{cinemaId}/showtimes", method = RequestMethod.GET)
//	public String ticketBuyForm(@PathVariable(value = "movieId") Long movieId, @PathVariable(value = "cinemaId") Long cinemaId,
//			Model model) {
//
//		Movie movie = movieRepository.findById(movieId).orElseThrow(
//				() -> new ResourceNotFoundException("Movie", "id", movieId));
//
//		Cinema cinema = cinemaRepository.findById(cinemaId).orElseThrow(
//				() -> new ResourceNotFoundException("Cinema", "id", cinemaId));
//
//		
//		model.addAttribute("movie", movie);
//		model.addAttribute("cinema", cinema);
//
//		return "buyaticket";
//	}

	// Loads the movie-create html page for admin.
	@GetMapping("/movies/movie-create")
	public String movieCreateForm(Model model) {
		model.addAttribute("movie", new Movie());
		return "admin/movie-create";
	}

	// Proccesses the movie creation and insertion into the database.
	@PostMapping("/movies/movie-create")
	public String movieCreateProccess(Movie movie) {
		movieRepository.save(movie);
		return "redirect:/";
	}

	// // Delete a Movie
	// @RequestMapping(value = "/movies/movie-delete", method =
	// RequestMethod.GET)
	// public String movieDeleteProccess(
	// @RequestParam(name = "movieId") Long movieId) {
	// Movie movie = movieRepository.findById(movieId).orElseThrow(
	// () -> new ResourceNotFoundException("Movie", "id", movieId));
	//
	// movieRepository.delete(movie);
	// return "redirect:/";
	// }

	// @DeleteMapping("/movies/movie-delete")
	// public String movieEdit(@PathVariable(value = "id") Long movieId) {
	//
	// Movie movie = movieRepository.findById(movieId).orElseThrow(
	// () -> new ResourceNotFoundException("Movie", "id", movieId));
	//
	// movieRepository.delete(movie);
	// return "redirect:/";
	// }

	@RequestMapping(value = "/movies/movie-delete", method = RequestMethod.GET)
	public String movieDeleteProccess(
			@RequestParam(name = "movieId") Long movieId) {

		Movie movie = movieRepository.findById(movieId).orElseThrow(
				() -> new ResourceNotFoundException("Movie", "id", movieId));

		movieRepository.delete(movie);
		//showtimeRepository.deleteShowtimesByMovieId(movieId);

		return "redirect:/";
	}

	@RequestMapping(value = "/movies/movie-edit", method = RequestMethod.GET)
	public String movieEditForm(@RequestParam(name = "movieId") Long movieId,
			Model model) {

		Movie movie = movieRepository.findById(movieId).orElseThrow(
				() -> new ResourceNotFoundException("Movie", "id", movieId));

		model.addAttribute(movie);

		return "admin/movie-edit";
	}

	@RequestMapping(value = "/movies/movie-edit", method = RequestMethod.POST)
	public String movieEditProccess(Movie movieDetails) {

		// Movie movie =
		// movieRepository.findById(movieDetails.getId()).orElseThrow(
		// () -> new ResourceNotFoundException("Movie", "id",
		// movieDetails.getId()));
		//
		movieRepository.save(movieDetails);

		// movie.setId(movieDetails.getId());
		// movie.setTitle(movieDetails.getTitle());
		// movie.setPlot(movieDetails.getPlot());
		// movie.setAgeLimit(movieDetails.getAgeLimit());
		// movie.setGenres(movieDetails.getGenres());
		// movie.setLanguage(movieDetails.getLanguage());
		// movie.setSubtitles(movieDetails.getSubtitles());
		// movie.setMovieLengthMinutes(movieDetails.getMovieLengthMinutes());

		// movieRepository.save(movie);

		return "redirect:/";
	}

	// @PutMapping("/movies/{id}") public Movie updateMovie(@PathVariable(value
	// = "id") Long movieId, @Valid @RequestBody Movie movieDetails) {
	//
	// Movie movie = movieRepository.findById(movieId) .orElseThrow(() -> new
	// ResourceNotFoundException("Movie", "id", movieId));
	//
	// movie.setTitle(movieDetails.getTitle());
	// movie.setPlot(movieDetails.getPlot());
	//
	// Movie updatedMovie = movieRepository.save(movie); return updatedMovie; }

	// // Proccesses the movie creation and insertion into the database.
	// @PostMapping("/movies/movie-create")
	// public String movieEditProccess(Movie movie) {
	// movieRepository.save(movie);
	// return "redirect:/";
	// }

	// @PutMapping("/movies/movie-edit")
	// public Movie updateMovie(@PathVariable(value = "id") Long movieId,
	// @Valid @RequestBody Movie movieDetails) {
	//
	// Movie movie = movieRepository.findById(movieId).orElseThrow(
	// () -> new ResourceNotFoundException("Movie", "id", movieId));
	//
	// movie.setTitle(movieDetails.getTitle());
	// movie.setPlot(movieDetails.getPlot());
	//
	// Movie updatedMovie = movieRepository.save(movie);
	// return updatedMovie;
	// }

	// // Loads the movie-create html page for admin.
	// @RequestMapping(value = "/movies/movie-edit", method = RequestMethod.GET)
	// public String movieDeleteProccess(
	// @RequestParam(name = "movieId") Long movieId) {
	// Movie movie = movieRepository.findById(movieId).orElseThrow(
	// () -> new ResourceNotFoundException("Movie", "id", movieId));
	//
	// movieRepository.delete(movie);
	// return "redirect:/";
	// }

	// // Update a Movie
	//
	// @PutMapping("/movies/{id}") public Movie updateMovie(@PathVariable(value
	// = "id") Long movieId, @Valid @RequestBody Movie movieDetails) {
	//
	// Movie movie = movieRepository.findById(movieId) .orElseThrow(() -> new
	// ResourceNotFoundException("Movie", "id", movieId));
	//
	// movie.setTitle(movieDetails.getTitle());
	// movie.setPlot(movieDetails.getPlot());
	//
	// Movie updatedMovie = movieRepository.save(movie); return updatedMovie; }

	// Loads the movie-create html page for admin.
	// @RequestMapping(value="/movies/movie-create", method = RequestMethod.GET)
	// public ModelAndView movieCreatePage(){
	// ModelAndView modelAndView = new ModelAndView();
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// User user = userRepository.findByEmail(auth.getName());
	// modelAndView.addObject("userName", "Welcome " + user.getName() + " " +
	// user.getLastName() + " (" + user.getEmail() + ")");
	// modelAndView.addObject("adminMessage","Content Available Only for Users
	// with Admin Role");
	// modelAndView.setViewName("admin/movie-create");
	// return modelAndView;
	// }

	// @RequestMapping(value = "/movies/movie-create", method =
	// RequestMethod.POST)
	// public ModelAndView createNewUser(@Valid Movie movie, BindingResult
	// bindingResult) {
	// ModelAndView modelAndView = new ModelAndView();
	// movieRepository.save(movie);
	// modelAndView.setViewName("/");
	// return modelAndView;
	// }

	// // PROCCESS
	// @RequestMapping(value="/movies/movie-create", method =
	// RequestMethod.POST)
	// public ModelAndView movieCreateProccess(Movie movie){
	// ModelAndView modelAndView = new ModelAndView();
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// User user = userService.findUserByEmail(auth.getName());
	// modelAndView.addObject("userName", "Welcome " + user.getName() + " " +
	// user.getLastName() + " (" + user.getEmail() + ")");
	// modelAndView.addObject("adminMessage","Content Available Only for Users
	// with Admin Role");
	// modelAndView.setViewName("/");
	// movieRepository.save(movie);
	// return modelAndView;
	// }

	// Loads the movie-create html page for admin.
	// @RequestMapping(value="/admin/movies/movie-create", method =
	// RequestMethod.POST)
	// public ModelAndView movieCreateProccess(Movie movie){
	// ModelAndView modelAndView = new ModelAndView();
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// User user = userService.findUserByEmail(auth.getName());
	// modelAndView.addObject("userName", "Welcome " + user.getName() + " " +
	// user.getLastName() + " (" + user.getEmail() + ")");
	// modelAndView.addObject("adminMessage","Content Available Only for Users
	// with Admin Role");
	// modelAndView.setViewName("admin/home");
	// return modelAndView;
	// }

	// @RequestMapping(value={"/admin/movies/movie-create"}, method =
	// RequestMethod.GET)
	// public ModelAndView movieCreatePage(){
	// ModelAndView modelAndView = new ModelAndView();
	// modelAndView.setViewName("movie");
	// return modelAndView;
	// }

	// // Proccesses the movie creation and insertion into the database.
	// @PostMapping("/admin/movies/movie-create")
	// public String createMovieProccess(Movie movie) {
	//
	// movieRepository.save(movie);
	// return "redirect:/admin/home";
	// }

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