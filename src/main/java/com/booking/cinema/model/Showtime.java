package com.booking.cinema.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Showtime")
public class Showtime {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long movieId;
	private Long auditoriumID;
	private Date dateAndTime;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getMovieId() {
		return movieId;
	}

	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	public Long getAuditoriumID() {
		return auditoriumID;
	}

	public void setAuditoriumID(Long auditoriumID) {
		this.auditoriumID = auditoriumID;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

	public Showtime(Long id, Long movieId, Long auditoriumID, Date dateAndTime) {
		setId(id);
		setMovieId(movieId);
		setAuditoriumID(auditoriumID);
		setDateAndTime(dateAndTime);
	}

}
