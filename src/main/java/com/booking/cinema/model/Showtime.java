package com.booking.cinema.model;

import java.util.Date;

import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Embeddable
@Entity
@Table(name = "Showtimes")
public class Showtime {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private Long cinemaId;
	private Long auditoriumId;
	private Long movieId;
	private Date dateAndTime;

	public Long getCinemaId() {
		return cinemaId;
	}

	public void setCinemaId(Long cinemaId) {
		this.cinemaId = cinemaId;
	}

	public Showtime(Long id, Long movieId, Long auditoriumID, Date dateAndTime) {
		setId(id);
		setMovieId(movieId);
		setAuditoriumId(auditoriumId);
		setDateAndTime(dateAndTime);
	}

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

	public Long getAuditoriumId() {
		return auditoriumId;
	}

	public void setAuditoriumId(Long auditoriumId) {
		this.auditoriumId = auditoriumId;
	}

	public Date getDateAndTime() {
		return dateAndTime;
	}

	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}

}
