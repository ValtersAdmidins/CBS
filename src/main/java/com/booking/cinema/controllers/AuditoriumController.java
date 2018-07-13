package com.booking.cinema.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.booking.cinema.enums.AgeLimit;
import com.booking.cinema.exceptions.ResourceNotFoundException;
import com.booking.cinema.model.Movie;
import com.booking.cinema.repositories.AuditoriumRepository;
import com.booking.cinema.repositories.MovieRepository;
import com.booking.cinema.repositories.UserRepository;

@Controller
public class AuditoriumController {

	@Autowired
	AuditoriumRepository auditoriumRepository;

	@RequestMapping("/auditoriums")
	public String showAllAuditoriums(Model model) {
		model.addAttribute("auditoriums", auditoriumRepository.findAll());
		return "auditoriums";
	}

	@RequestMapping("/auditoriums/{id}")
	public String getAuditoriumById(@PathVariable(value = "id") Long auditoriumId, Model model) {
		model.addAttribute("auditorium", auditoriumRepository.findById(auditoriumId)
				.orElseThrow(() -> new ResourceNotFoundException("Auditorium", "id", auditoriumId)));
		return "auditorium";
	}
}