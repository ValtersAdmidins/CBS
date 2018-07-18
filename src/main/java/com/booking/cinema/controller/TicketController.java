package com.booking.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.booking.cinema.model.Ticket;
import com.booking.cinema.repositories.TicketRepository;

@Controller
public class TicketController {

	@Autowired
	TicketRepository ticketRepository;

	// Loads the buyaticket html page.
	@GetMapping("/buyaticket")
	public String ticketBuyForm(Model model) {
		model.addAttribute("ticket", new Ticket());
		return "buyaticket";
	}

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
