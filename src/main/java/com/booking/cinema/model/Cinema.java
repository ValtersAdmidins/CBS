package com.booking.cinema.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cinema")
public class Cinema {

	private Long id;
	private String name;
	private String address;
	private String location_koordinates;
	
	private Set<Auditorium> auditoriums;
	private Set<Movie> movies;

	public Cinema() {

	}

	public Cinema(String name, String address, String location_koordinates) {
		this.name = name;
		this.address = address;
		this.location_koordinates = location_koordinates;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getLocation_koordinates() {
		return location_koordinates;
	}

	public void setLocation_koordinates(String location_koordinates) {
		this.location_koordinates = location_koordinates;
	}

	
	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
	public Set<Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(Set<Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}

	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
	public Set<Movie> getMovies() {
		return movies;
	}

	public void setMovies(Set<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", address=" + address + ", location_koordinates="
				+ location_koordinates + ", auditoriums=" + auditoriums + ", movies=" + movies + "]";
	}
	
}