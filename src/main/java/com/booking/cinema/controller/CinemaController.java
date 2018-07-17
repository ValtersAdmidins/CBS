package com.booking.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.booking.cinema.model.Cinema;
import com.booking.cinema.model.User;
import com.booking.cinema.repositories.CinemaRepository;
import com.booking.cinema.service.UserService;

 

@Controller
public class CinemaController {

	@Autowired
	CinemaRepository cinemaRepository;
	
	@Autowired
	private UserService userService;

	@RequestMapping("/cinemas")
	public String showAllMovies(Model model) {
		model.addAttribute("cinemas", cinemaRepository.findAll());
		return "cinemas";
	}

/*
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
*/
//	// Loads the cinama-create html page.
//	@GetMapping("/cinemas/cinema-create")
//	public String cinemaCreatePage(Model model) {
//		model.addAttribute("cinema", new Cinema());
//		return "cinema-create";
//	}
	
	// Loads the cinema-create html page for admin.
	@RequestMapping(value="/admin/cinemas/cinema-create", method = RequestMethod.GET)
	public ModelAndView movieCreatePage(){
		ModelAndView modelAndView = new ModelAndView();
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		User user = userService.findUserByEmail(auth.getName());
		modelAndView.addObject("userName", "Welcome " + user.getName() + " " + user.getLastName() + " (" + user.getEmail() + ")");
		modelAndView.addObject("adminMessage","Content Available Only for Users with Admin Role");
		modelAndView.setViewName("admin/cinema-create");
		return modelAndView;
	}

//	// Proccesses the cinema creation and insertion into the database.
//	@PostMapping("/cinemas/cinema-create")
//	public String createCinemaProccess(Cinema cinema) {
//
//		cinema.setLatitudeAndLongitudeFromAddress();
//		cinemaRepository.save(cinema);
//		return "redirect:/cinemas";
//	}
}