package com.booking.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.model.Auditorium;
import com.booking.cinema.model.Cinema;
import com.booking.cinema.repositories.AuditoriumRepository;
import com.booking.cinema.repositories.CinemaRepository;
import com.booking.cinema.repositories.UserRepository;

@Controller
public class CinemaController {

	@Autowired
	CinemaRepository cinemaRepository;

	@Autowired
	AuditoriumRepository auditoriumRepository;

	@Autowired
	UserRepository userRepository;

	@RequestMapping("/cinemas")
	public String showAllMovies(Model model) {
		model.addAttribute("cinemas", cinemaRepository.findAll());
		return "cinemas";
	}

	@RequestMapping("/cinemas/{id}")
	public String getCinemaById(@PathVariable(value = "id") Long cinemaId,
			Model model) {
		model.addAttribute("cinema",
				cinemaRepository.findById(cinemaId).orElseThrow(
						() -> new ResourceNotFoundException("Cinema", "id",
								cinemaId)));
		return "cinema";
	}

	// Loads the cinema-create html page for admin.
	@GetMapping("/cinemas/cinema-create")
	public String cinemaCreateForm(Model model) {
		model.addAttribute("cinema", new Cinema());
		return "admin/cinema-create";
	}

	// Proccesses the cinema creation and insertion into the database.
	@PostMapping("/cinemas/cinema-create")
	public String cinemaCreateProccess(Cinema cinema) {
		cinema.setLatitudeAndLongitudeFromAddress();
		cinemaRepository.save(cinema);
		return "redirect:/cinemas";
	}

	// Loads the auditorium-create html page for admin.
	@GetMapping("/cinemas/auditorium-create")
	public String auditoriumCreateForm(Model model) {
		model.addAttribute("auditorium", new Auditorium());
		return "admin/auditorium-create";
	}

	// Proccesses the auditorium creation and insertion into the database.
	@PostMapping("/cinemas/auditorium-create")
	public String auditoriumCreateProccess(Auditorium auditorium) {

		auditoriumRepository.save(auditorium);
		return "redirect:/cinemas";
	}

	/*
	 * @RequestMapping("/cinemas/{id}") public String showAllMoviesinCinema(
	 * 
	 * @PathVariable(value = "id") Long cinemaID, Model model) {
	 * Optional<Cinema> cinema = cinemaRepository.findById(cinemaID); Set<Movie>
	 * movies = new HashSet<>(); if (cinema.isPresent()) { movies =
	 * cinema.get().getMovies(); model.addAttribute("cinema", cinema.get()); }
	 * 
	 * model.addAttribute("movies", movies);
	 * 
	 * return "cinema"; }
	 */
	// // Loads the cinama-create html page.
	// @GetMapping("/cinemas/cinema-create")
	// public String cinemaCreatePage(Model model) {
	// model.addAttribute("cinema", new Cinema());
	// return "cinema-create";
	// }

	// // Loads the cinema-create html page for admin.
	// @RequestMapping(value="/admin/cinemas/cinema-create", method =
	// RequestMethod.GET)
	// public ModelAndView movieCreatePage(){
	// ModelAndView modelAndView = new ModelAndView();
	// Authentication auth =
	// SecurityContextHolder.getContext().getAuthentication();
	// User user = userRepository.findByEmail(auth.getName());
	// modelAndView.addObject("userName", "Welcome " + user.getName() + " " +
	// user.getLastName() + " (" + user.getEmail() + ")");
	// modelAndView.addObject("adminMessage","Content Available Only for Users
	// with Admin Role");
	// modelAndView.setViewName("admin/cinema-create");
	// return modelAndView;
	// }

	// // Proccesses the cinema creation and insertion into the database.
	// @PostMapping("/cinemas/cinema-create")
	// public String createCinemaProccess(Cinema cinema) {
	//
	// cinema.setLatitudeAndLongitudeFromAddress();
	// cinemaRepository.save(cinema);
	// return "redirect:/cinemas";
	// }
}