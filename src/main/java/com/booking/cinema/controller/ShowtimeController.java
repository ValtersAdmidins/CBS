package com.booking.cinema.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.model.Auditorium;
import com.booking.cinema.model.Cinema;
import com.booking.cinema.model.Showtime;
import com.booking.cinema.model.Ticket;
import com.booking.cinema.model.User;
import com.booking.cinema.repositories.AuditoriumRepository;
import com.booking.cinema.repositories.CinemaRepository;
import com.booking.cinema.repositories.MovieRepository;
import com.booking.cinema.repositories.ShowtimeRepository;
import com.booking.cinema.repositories.TicketRepository;
import com.booking.cinema.service.UserService;

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
	
	@Autowired
	TicketRepository ticketRepository;
	
	@Autowired
	UserService userService;
	
	
	
	
	@RequestMapping("/showtimes")
	public String showAllShowtimes(Model model) {
		
		model.addAttribute("showtimes", showtimeRepository.findAll());
		return "admin/showtimes";
	}
//	
//	
//	// Loads the auditorium-create html page.
//		@GetMapping("/cinemas/auditorium-create")
//		public String auditoriumCreatePage(  Model model) {
//			model.addAttribute("auditorium", new Auditorium());
//			
//			return "admin/auditorium-create";
//		}
//		
//		
//		// Proccesses the auditorium creation and insertion into the database.
//			@PostMapping("/cinemas/auditorium-create")
//			public String auditoriumCreateProccess(Auditorium auditorium) {
//				auditoriumRepository.save(auditorium);
//				return "redirect:/auditories";
//			} 
//	
	@GetMapping("/showtimes/showtime-create")
	public String showtimeCreateForm(@RequestParam(value = "cinemaId") Long cinemaid, Model model) {
		
		model.addAttribute("mvs", movieRepository.findAll());
		model.addAttribute("auditoriums",auditoriumRepository.findAllAuditoriumsInCinema(cinemaid));
		model.addAttribute("showtime",new Showtime());
		
		return "admin/showtime-create";
	}
	
	
	@RequestMapping(value = "/showtimes/showtime-create", method=RequestMethod.POST)
	public String showtimeCreateProccess(Showtime showtime) {
		
		showtime.setTakenSeats(showtime.getAuditorium().getSeats());
		showtimeRepository.save(showtime);
		return "redirect:/showtimes";
	}
	

	@RequestMapping(value = "/showtimes/showtime-edit", method=RequestMethod.POST)
	public String showtimeEditSeats(Showtime showtime, @RequestParam(value = "column") int column, @RequestParam(value = "row") int row) {
		
		Authentication auth = SecurityContextHolder.getContext().getAuthentication(); 
		UserDetails userDetail = (UserDetails) auth.getPrincipal();
		User user = userService.findUserByEmail(userDetail.getUsername()); 

		
		Ticket t = new Ticket();
		t.setColumn(column);
		t.setRow(row);
		t.setShowtime(showtime);
		t.setUser(user);
		t.setDate();
		ticketRepository.save(t);
		showtimeRepository.save(showtime);
		return "redirect:/showtimes";
	}
	

	@RequestMapping(value = "/showtimes/showtime-delete", method = RequestMethod.GET)
	public String showtimeDeleteProccess(	
			@RequestParam(name = "showtimeId") Long showtimeId) {

		Showtime showtime =showtimeRepository.findById(showtimeId).orElseThrow(
				() -> new ResourceNotFoundException("Movie", "id",
						showtimeId));

		showtimeRepository.delete(showtime);

		return "redirect:/showtimes";
}
	
	
	
}
