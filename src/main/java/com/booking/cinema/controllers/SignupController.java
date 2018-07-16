//package com.booking.cinema.controllers;
//
//import java.util.HashSet;
//import java.util.Optional;
//import java.util.Set;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.booking.cinema.model.Cinema;
//import com.booking.cinema.model.Movie;
//import com.booking.cinema.repositories.CinemaRepository;
//
//@Controller
//public class SignupController {
//
//	@Autowired
//	UserRepository userRepository;
//	
//	// Loads the signup html page.
//	@GetMapping("/signup")
//	public String signupPage() {
//		return "signup";
//	}
//
//	// Proccesses the movie creation and insertion into the database.
//	@PostMapping("/movies/movie-create")
//	public String signupProccess(User user) {
//		userRepository.save(user);
//		return "redirect:/";
//	}
//	
//}