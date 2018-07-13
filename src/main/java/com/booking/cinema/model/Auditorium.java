package com.booking.cinema.model;

import java.util.Arrays;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "Auditorium")
public class Auditorium {
	@NotBlank
	private boolean[][]  auditoriumSize;
	
	private int seatCount;
	private int seatCountR;
	private int seatCountC;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int auditoriumId;
	
	public Auditorium() {
		this.seatCount=6;
		this.auditoriumSize = new boolean[seatCount][seatCount];
 	}
	public Auditorium(int seatCountR, int seatCountC, boolean[][] auditoriumSize) {
		this.seatCountR=seatCountR;
		this.seatCountC=seatCountC;
		this.auditoriumSize = new boolean[seatCountR][seatCountC];

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
		return auditoriumSize;
	}
	public void setSeats(boolean[][] auditoriumSize) {
		this.auditoriumSize = auditoriumSize;
	}
	public int getAuditoriumId() {
		return auditoriumId;
	}
	
	public boolean seatIsTaken(int seatCountR,int seatCountC ) {

		if (auditoriumSize[seatCountR][seatCountC] == true)
			return true;
		else 
			return false;
	}
	
	public void setAuditoriumId(int auditoriumSize) {
		
		if (auditoriumId > 0) {
			this.auditoriumId = auditoriumId;
		}
		else {
			System.out.println("Auditorium id cannot less that 0");
			this.auditoriumId = 0;
		}
		
	}
	
	public String toString() {
		return " "+auditoriumId+Arrays.toString(auditoriumSize);
	}
	
	
}
