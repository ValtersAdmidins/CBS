package com.booking.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
<<<<<<< HEAD
import org.springframework.web.bind.annotation.GetMapping;

import com.booking.cinema.model.Auditorium;
import com.booking.cinema.repositories.CinemaRepository;

@Controller
public class TicketController {
	
	@Autowired
	CinemaRepository cinemaRepository;

	@GetMapping("/buyaticket")
	public String buyaticket(Model model) {
	
	 //temporary - auditorium has to be taken from database
	 Long l = (long) 1;
	 Auditorium tmp = new Auditorium();
	 model.addAttribute("auditoriumString", "03310211033213033");
	 return "buyaticket";
	 }
	
	
}
=======
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.repository.TicketRepository;
 
@Controller
public class TicketController {


	@Autowired
	TicketRepository ticketRepository;
	
	@RequestMapping("/tickets")
	public String showAllTickets(Model model) {
		model.addAttribute("tickets", ticketRepository.findAll());
		return "tickets";
	}




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
>>>>>>> valters3
