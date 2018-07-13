package com.booking.cinema.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Showtime")
public class Showtime {

	@Id
	private int id;
	private int movieId;
	private int auditoriumID;
	private Date dateAndTime;
	
	public Showtime(int id, int movieId, int auditoriumID, Date dateAndTime) {
		setId(id);
		setMovieId(movieId);
		setAuditoriumID(auditoriumID);
		setDateAndTime(dateAndTime);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public int getAuditoriumID() {
		return auditoriumID;
	}
	public void setAuditoriumID(int auditoriumID) {
		this.auditoriumID = auditoriumID;
	}
	public Date getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	
	
	
	
	
}
