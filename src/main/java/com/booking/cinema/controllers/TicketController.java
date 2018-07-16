package com.booking.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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
	 tmp.setSeatCountC(5);
	 tmp.setSeatCountR(3);
	 model.addAttribute("auditoriumString", "111110211141021100102111111210111121111112");
	 model.addAttribute("columns",tmp.getSeatCountC());
	 model.addAttribute("rows",tmp.getSeatCountR());
	 return "buyaticket";
	 }
	
	
}
