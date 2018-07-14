package com.booking.cinema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	@RequestMapping("/movies/movie-create")
	public String movieCreatePage() {
		return "movie-create";

	}
}