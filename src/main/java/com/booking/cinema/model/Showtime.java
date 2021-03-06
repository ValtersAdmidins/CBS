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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Showtime {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "movie_id")
	private Movie movie;

	
	@ManyToOne
	@JoinColumn(name = "auditorium_id")
	private Auditorium auditorium;
	

	@ManyToOne
	@JoinColumn(name = "cinema_id")
	private Cinema cinema;
	
	@Column(columnDefinition = "TEXT")
	private String takenSeats;
	
    @Column
	private Date dateAndTime;
   // @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    //public Set<Ticket> tickets;
    public Showtime() {
	}
 
	 



	public Showtime(Long id, String dateAndTime) {
		setId(id);
		setDateAndTime(dateAndTime);
	}
	
	public String getTakenSeats() {
		return takenSeats;
	}

	public void setTakenSeats(String takenSeats) {
		this.takenSeats = takenSeats;
	}

	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public void setDateAndTime(String str) {
		this.dateAndTime = getDateFromString(str);
	}
	
	private Date getDateFromString(String str) {
		String filtered = str.replaceAll("[^0-9,]"," ");
		String[] numbers = filtered.split(" ");
		return new Date(Integer.parseInt(numbers[0])-1900, Integer.parseInt(numbers[1]), Integer.parseInt(numbers[2]), Integer.parseInt(numbers[3]), Integer.parseInt(numbers[4]));
	}
	
	
}