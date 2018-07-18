package com.booking.cinema.model;

import java.util.Date;
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
public class Showtime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	public Movie movie;
	
	@ManyToOne
	@JoinColumn(name = "auditorium_id")
	public Auditorium auditorium;
	
	@ManyToOne
	@JoinColumn(name = "cinema_id")
	public Cinema cinema;
	
	@Column
	private String takenSeats;
	
    @Column
	private Date dateAndTime;
   // @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    //public Set<Ticket> tickets;
    
 
	 

	public Showtime(int id, Date dateAndTime) {
		setId(id);
 
		setDateAndTime(dateAndTime);
	}
	
	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Movie getMovie() {
		return movie;
	}
	public void setMovie(Movie movie) {
		this.movie = movie;
	}
	public Auditorium getAuditorium() {
		return auditorium;
	}
	public void setAuditorium(Auditorium auditorium) {
		this.auditorium = auditorium;
	}
	public Date getDateAndTime() {
		return dateAndTime;
	}
	public void setDateAndTime(Date dateAndTime) {
		this.dateAndTime = dateAndTime;
	}
	
	
}