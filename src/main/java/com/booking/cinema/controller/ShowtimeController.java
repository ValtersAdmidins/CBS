package com.booking.cinema.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.booking.cinema.repositories.ShowtimeRepository;

@Controller
public class ShowtimeController {
	
	@Autowired
	ShowtimeRepository showtimeRepository;
	
	
	
	
}
