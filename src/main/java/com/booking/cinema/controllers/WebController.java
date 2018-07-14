package com.booking.cinema.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {

	@RequestMapping("/cinemas/cinema-create")
	public String cinemaCreatePage() {
		return "cinema-create";
	}
}