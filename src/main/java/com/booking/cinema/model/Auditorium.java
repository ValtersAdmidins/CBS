package com.booking.cinema.model;

import java.util.Arrays;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Embeddable
@Entity
@Table(name = "Auditoriums")
public class Auditorium {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long cinemaId;

	public Long getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	@NotBlank
	private boolean[][] auditoriumSeats;

	private int seatCountR;
	private int seatCountC;

	public Auditorium() {
		this.seatCountR = 0;
		this.seatCountC = 0;
		this.auditoriumSeats = new boolean[seatCountR][seatCountC];
	}

	public Auditorium(int seatCountR, int seatCountC, boolean[][] auditoriumSize) {
		this.seatCountR = seatCountR;
		this.seatCountC = seatCountC;
		this.auditoriumSeats = new boolean[seatCountR][seatCountC];

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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public boolean[][] getAuditoriumSeats() {
		return auditoriumSeats;
	}

	public void setAuditoriumSeats(boolean[][] auditoriumSeats) {
		this.auditoriumSeats = auditoriumSeats;
	}

	public boolean seatIsTaken(int seatCountR, int seatCountC) {

		if (auditoriumSeats[seatCountR][seatCountC] == true)
			return true;
		else
			return false;
	}

	public String toString() {
		return " " + id + Arrays.toString(auditoriumSeats);
	}

}
