package com.booking.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.model.Movie;
import com.booking.cinema.repositories.MovieRepository;
import com.booking.cinema.repositories.TicketRepository;

@Controller
public class TicketController {

	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	MovieRepository movieRepository;
	

//	// Loads the buyaticket html page.
//	@GetMapping("/tickets")
//	public String ticketBuyForm(Model model) {
//		model.addAttribute("ticket", new Ticket());
//		return "buyaticket";
//	}
	
	@RequestMapping(value = "/tickets", method = RequestMethod.GET)
	public String ticketBuyForm(
			@RequestParam(name = "movieId") Long movieId, Model model) {

		Movie movie = movieRepository.findById(movieId).orElseThrow(
				() -> new ResourceNotFoundException("Movie", "id", movieId));

		model.addAttribute("movie", movie);
		model.addAttribute("cinemas", cinemaRepository.findAll());
		
		return "chooseCinema";
	}
	
	

//	// Loads the choose cinema html page.
//	@GetMapping("/buyaticket")
//	public String ticketBuyProccess(Model model) {
//		model.addAttribute("ticket", new Ticket());
//		return "buyaticket";
//	}

	// // Proccesses the movie creation and insertion into the database.
	// @PostMapping("/movies/movie-create")
	// public String ticketButProccess(Movie movie) {
	// movieRepository.save(movie);
	// return "redirect:/";
	// }

	// @Autowired
	// CinemaRepository cinemaRepository;
	//
	// @RequestMapping("/cinemas/cinema-create")
	// public String cinemaCreatePage() {
	// return "cinema-create";
	// }
	//
	//
	// @RequestMapping("/signup")
	// public String signup() {
	// return "signup";
	// }
	// @RequestMapping("/movies/movie-create")
	// public String movieCreatePage() {
	// return "movie-create";
	//
	// }
	//
	// @GetMapping("/buyaticket")
	// public String buyaticket(Model model) {
	//
	// //temporary - auditorium has to be taken from database
	// Long l = (long) 1;
	// Auditorium tmp = new Auditorium(50,cinemaRepository.findById(l).get());
	//
	//
	// model.addAttribute("columns",tmp.getSeatCountC());
	// model.addAttribute("rows",tmp.getSeatCountR());
	// return "buyaticket";
	// }
}
