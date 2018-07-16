package com.booking.cinema.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.repositories.UserRepository;

 
@Controller
public class UserController {


	@Autowired
	UserRepository userRepository;
	
	@RequestMapping("/users")
	public String showAllUsers (Model model) {
		model.addAttribute("users", userRepository.findAll());
		return "users";
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