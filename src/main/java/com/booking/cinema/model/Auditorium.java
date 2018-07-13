package com.booking.cinema.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Auditorium {

	private Long id;
	private int room;
	private Cinema cinema;
	
	public Auditorium() {
		
	}
	
	public Auditorium(int room) {
		this.room = room;
	}

	public Auditorium(int room, Cinema cinema) {
		this.room = room;
		this.cinema = cinema;
	}

	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getRoom() {
		return room;
	}

	public void setRoom(int room) {
		this.room = room;
	}

	@ManyToOne
    @JoinColumn(name = "cinema_id")
	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

}
