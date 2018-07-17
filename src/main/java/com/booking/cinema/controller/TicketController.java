package com.booking.cinema.controller;

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
	 model.addAttribute("auditoriumString", "03310211033213033");
	 return "buyaticket";
	 }
	
	
}
