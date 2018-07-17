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
	private String roomNumber;
	private String seats;
	private Cinema cinema;

	public Auditorium() {

	}

	public Auditorium(String roomNumber, String seats) {
		setRoomNumber(roomNumber);
		setSeats(seats);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRoomNumber() {
		return roomNumber;
	}

	public void setRoomNumber(String roomNumber) {
		this.roomNumber = roomNumber;
	}

	public void setSeats(String seats) {
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
		return "Auditorium [id=" + id + ", roomNumber=" + roomNumber
				+ ", seats=" + seats + ", cinema=" + cinema + "]";
	}

}
