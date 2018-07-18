package com.booking.cinema.model;

import java.util.Arrays;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Auditorium {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column
	private String roomNumber;
	
	@Column(columnDefinition = "TEXT")
	private String seats;
	
	@ManyToOne
	@JoinColumn(name = "cinema_id")
	public Cinema cinema;

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
	

	public String getSeats() {
		return seats;
	}


	@Override
	public String toString() {
		return "Auditorium [id=" + id + ", roomNumber=" + roomNumber + ", seats=" + seats + "]";
	}

	

	
	 
	 

}