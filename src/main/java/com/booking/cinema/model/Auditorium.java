package com.booking.cinema.model;

import java.util.Arrays;

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
	private int seatCountR;
	private int seatCountC;
	private boolean[][] seats;
	
	private Cinema cinema;
	
	public Auditorium() {
		
	}

	public Auditorium(int roomNumber, int seatCountR, int seatCountC, boolean[][] seats) {
		this.roomNumber = roomNumber;
		this.seatCountR = seatCountR;
		this.seatCountC = seatCountC;
		this.seats = seats;
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

	public int getSeatCountR() {
		return seatCountR;
	}

	public void setSeatCountR(int seatCountR) {
		this.seatCountR = seatCountR;
	}

	public int getSeatCountC() {
		return seatCountC;
	}

	public void setSeatCountC(int seatCountC) {
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

	@Override
	public String toString() {
		return "Auditorium [id=" + id + ", roomNumber=" + roomNumber + ", seatCountR=" + seatCountR + ", seatCountC="
				+ seatCountC + ", seats=" + Arrays.toString(seats) + ", cinema=" + cinema + "]";
	}

	
}
