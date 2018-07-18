package com.booking.cinema.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
import com.booking.cinema.model.Movie;
import com.booking.cinema.model.Showtime;
import com.booking.cinema.repositories.AuditoriumRepository;
import com.booking.cinema.repositories.CinemaRepository;

@Controller
public class AuditoriumController {

	///@Autowired
	//CinemaRepository cinemaRepository;
	
	@Autowired
	AuditoriumRepository auditoriumRepository;
	
	@Autowired
	CinemaRepository cinemaRepository;
	
	@RequestMapping("/auditories")
	public String showAllAuditories(Model model) {
		
		model.addAttribute("auditories", auditoriumRepository.findAll());
		return "admin/auditories";
	}

	// Loads the auditorium-create html page.
	@GetMapping("/auditories/auditorium-create")
	public String auditoriumCreatePage(Model model) {
		model.addAttribute("auditorium", new Auditorium());
		model.addAttribute("cinemas", cinemaRepository.findAll());
		
		return "admin/auditorium-create";
	}
	
	
	// Proccesses the auditorium creation and insertion into the database.
		@PostMapping("/auditories/auditorium-create")
		public String auditoriumCreateProccess(Auditorium auditorium) {
			auditoriumRepository.save(auditorium);
			return "redirect:/auditoriums ";
		}
		
		@RequestMapping(value = "/auditories/auditorium-delete", method = RequestMethod.GET)
		public String auditoriumDeleteProccess(	
				@RequestParam(name = "auditoriumId") Long auditoriumId) {

			Auditorium auditorium =auditoriumRepository.findById(auditoriumId).orElseThrow(
					() -> new ResourceNotFoundException("Auditorium", "id",
							auditoriumId));

			auditoriumRepository.delete(auditorium);

			return "redirect:/auditoriums";
	}

}