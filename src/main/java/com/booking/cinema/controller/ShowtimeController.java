package com.booking.cinema.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.model.Auditorium;
import com.booking.cinema.model.Cinema;
import com.booking.cinema.model.Showtime;
import com.booking.cinema.repositories.AuditoriumRepository;
import com.booking.cinema.repositories.CinemaRepository;
import com.booking.cinema.repositories.MovieRepository;
import com.booking.cinema.repositories.ShowtimeRepository;

@Controller
public class ShowtimeController {
	
	@Autowired
	ShowtimeRepository showtimeRepository;
	
	@Autowired
	MovieRepository movieRepository;
	
	@Autowired
	CinemaRepository cinemaRepository;
	
	@Autowired
	AuditoriumRepository auditoriumRepository;
	
	
	
	
	@RequestMapping("/showtimes")
	public String showAllMovies(Model model) {
		
		model.addAttribute("showtimes", showtimeRepository.findAll());
		return "admin/showtimes";
	}
	
	@GetMapping("/showtimes/showtime-create")
	public String cinemaCreateForm(Model model) {
		
		model.addAttribute("mvs", movieRepository.findAll());
		model.addAttribute("cinemas",cinemaRepository.findAll());
		model.addAttribute("auditoriums",auditoriumRepository.findAll());
		model.addAttribute("showtime",new Showtime());
		
		return "admin/showtime-create";
	}
	
	
	@PostMapping("/showtimes/showtime-create")
	public String showtimeCreateProccess(Showtime showtime) {
		
		//showtime.setDateFromString();
		showtime.setTakenSeats(showtime.getAuditorium().getSeats());
		showtimeRepository.save(showtime);
		return "redirect:/showtimes";
	}
	

	@RequestMapping(value = "/showtimes/showtime-delete", method = RequestMethod.GET)
	public String movieDeleteProccess(	
			@RequestParam(name = "showtimeId") Long showtimeId) {

		Showtime showtime =showtimeRepository.findById(showtimeId).orElseThrow(
				() -> new ResourceNotFoundException("Movie", "id",
						showtimeId));

		showtimeRepository.delete(showtime);

		return "redirect:/showtimes";
}
	
	
	
}
