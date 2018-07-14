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
	private int roomNumber;
	private boolean seatCountR;
	private boolean seatCountC;
	private boolean[][] seats;
	private Cinema cinema;
	
	public Auditorium() {
		
	}
	
	public Auditorium(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public Auditorium(int roomNumber, Cinema cinema) {
		this.roomNumber = roomNumber;
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

	public int getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}

	public boolean isSeatCountR() {
		return seatCountR;
	}

	public void setSeatCountR(boolean seatCountR) {
		this.seatCountR = seatCountR;
	}

	public boolean isSeatCountC() {
		return seatCountC;
	}

	public void setSeatCountC(boolean seatCountC) {
		this.seatCountC = seatCountC;
	}

	public boolean[][] getSeats() {
		return seats;
	}

	public void setSeats(boolean[][] seats) {
		this.seats = seats;
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
