package com.booking.cinema.controllers;

import java.util.List;

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
import com.booking.cinema.model.Auditorium;
import com.booking.cinema.model.Movie;
import com.booking.cinema.model.Ticket;
import com.booking.cinema.repositories.AuditoriumRepository;
import com.booking.cinema.repositories.TicketRepository;
 
@Controller
//@RequestMapping("/api")
public class TicketController {

	@Autowired
	TicketRepository ticketRepository;
	
	@RequestMapping("/tickets")
    public String showAlltTickets(Model model){
        model.addAttribute("Ticket", ticketRepository.findAll());
        return "index";
    }

	public List<Ticket> returnAListAllTicket() {
		return ticketRepository.findAll();
	}

	// Create a new Ticket
	//@PostMapping("/ticket")
	public Ticket createAticket(@Valid @RequestBody Ticket ticket) {
		return ticketRepository.save(ticket);
	}

	// Get a Single Movie
	@RequestMapping("/tickets/{id}")
	public String getTicketById(@PathVariable(value = "id") long  id, Model model) {
		model.addAttribute("ticket", ticketRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("ticket", "id", id)));
		return "ticket";
	}
	
	@PostMapping("/buyaticket")
	public String getTicketById( Model model) {
		return "ticket";
	}
	
/*
	// Update a Movie
	@PutMapping("/auditorium/{id}")
	public Auditorium updateAuditorium(@PathVariable(value = "auditorium") int id, @Valid @RequestBody Auditorium auditoriumDetails) {

		Auditorium auditorium = auditoriumRepository.findById((long) id)
				.orElseThrow(() -> new ResourceNotFoundException("Auditorium", "id", id));

		auditorium.setSeatCountR(auditoriumDetails.getSeatCountR());
		auditorium.setSeatCountC(auditoriumDetails.getSeatCountC());

		Auditorium updatedAuditorium = auditoriumRepository.save(auditorium);
		return updatedAuditorium;
	}

	// Delete a Movie
	@DeleteMapping("/auditorium/{id}")
	public ResponseEntity<?> deleteAuditorium(@PathVariable(value = "id") int id) {
		Auditorium auditorium = auditoriumRepository.findById((long) id)
				.orElseThrow(() -> new ResourceNotFoundException("Auditorium", "id", id));

		auditoriumRepository.delete(auditorium);

		return ResponseEntity.ok().build();
	}
	
	// View sample movie
	@GetMapping(path = "/movies/sample")
	public String viewSampleMovie(Model model) {
		
		Movie movie = new Movie();
		model.addAttribute("title", movie.getTitle());
		AgeLimit al = movie.getAgeLimit();
		switch (al) {
		case NOLIMIT:
			model.addAttribute("ageLimit", "U");
			break;
		case PLUSEIGHTTEEN:
			model.addAttribute("ageLimit", "+18");
			break;
		case PLUSSIXTEEN:
			model.addAttribute("ageLimit", "+16");
			break;
		}

		model.addAttribute("genres", movie.getGenres());
		model.addAttribute("lang", movie.getLanguage());
		model.addAttribute("subs", movie.getSubtitles());
		model.addAttribute("length", movie.getMovieLength());

		return "displaymovie";
	}*/
}
