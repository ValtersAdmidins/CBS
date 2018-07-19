package com.booking.cinema.controller;

import java.util.ArrayList;
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
import org.springframework.web.bind.annotation.PathVariable;
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
		/*
		List<String> auditoriesWithCinInfo = new ArrayList<>();
		String cinemaName = "";
		String cinemaAddress = "";
		List<Auditorium> allAuditories = auditoriumRepository.findAll();
		for(Auditorium a : allAuditories) {
				cinemaName = cinemaRepository.findById(a.getCinemaId()).get().getName();
				cinemaAddress = cinemaRepository.findById(a.getCinemaId()).get().getAddress();
			
			auditoriesWithCinInfo.add(a.getRoomNumber());
			
		}
		
		for(String x : auditoriesWithCinInfo) {
			System.out.println(x);
			
		}
		
		model.addAttribute("auditories", auditoriesWithCinInfo);*/
		
		
		
		model.addAttribute("auditories", auditoriumRepository.findAll());
		
		
		return "admin/auditories";
	}

	// Loads the auditorium-create html page.
	@GetMapping("/cinemas/auditorium-create")
	public String auditoriumCreatePage(  Model model) {
		model.addAttribute("auditorium", new Auditorium());
		
		return "admin/auditorium-create";
	}
	
	
	// Proccesses the auditorium creation and insertion into the database.
		@PostMapping("/cinemas/auditorium-create")
		public String auditoriumCreateProccess(Auditorium auditorium) {
			auditoriumRepository.save(auditorium);
			return "redirect:/auditories";
		}
		
		
		@RequestMapping(value = "/auditories/auditorium-delete", method = RequestMethod.GET)
		public String auditoriumDeleteProccess(	
				@RequestParam(name = "auditoriumId") Long auditoriumId) {

			Auditorium auditorium =auditoriumRepository.findById(auditoriumId).orElseThrow(
					() -> new ResourceNotFoundException("Auditorium", "id",
							auditoriumId));

			auditoriumRepository.delete(auditorium);

			return "redirect:/auditories";
	}
		
		
		
		@RequestMapping(value = "/auditories/auditorium-edit/{auditoriumId}", method = RequestMethod.GET)
		public String auditoriumEdit(
				@RequestParam(name = "auditoriumId") Long auditoriumId, Model model) {

			Auditorium auditorium = auditoriumRepository.findById(auditoriumId).orElseThrow(
					() -> new ResourceNotFoundException("auditorium", "id", auditoriumId));
			
			model.addAttribute(auditorium);

			return "admin/auditorium-edit";
		}
		
		@RequestMapping(value = "/auditories/auditorium-edit", method = RequestMethod.POST)
		public String auditoriumEditProccess(Auditorium auditorium) {

//			
			auditoriumRepository.save(auditorium);
			
			return "redirect:/";
		}

}