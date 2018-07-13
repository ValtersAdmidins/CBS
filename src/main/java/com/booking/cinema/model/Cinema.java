package com.booking.cinema.model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CollectionTable;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

@Entity
@Table(name = "Cinemas")
public class Cinema {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	@NotBlank
	private String name;

	@NotBlank
	private String address;

	private double latitude;
	private double longitude;

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "cinema_showtimes", joinColumns = @JoinColumn(name = "cinema_id"))
	private Set<Showtime> movieSessions = new HashSet<>();

	@ElementCollection(fetch = FetchType.LAZY)
	@CollectionTable(name = "cinema_auditoriums", joinColumns = @JoinColumn(name = "cinema_id"))
	private Set<Auditorium> cinemaAuditoriums = new HashSet<>();

	// private ArrayList<Auditorium> cinemaAuditoriums;

	public Cinema() {
		setName("DefaultName");
		setAddress("DefaultAddress");
		setMovieSessions(new HashSet<>());
		setLatitudeAndLongitudeFromAddress();
		setCinemaAuditoriums(new HashSet<>());

	}

	public Cinema(String name, String address, Set<Showtime> movieSessions, Set<Auditorium> cinemaAuditoriums) {
		setName(name);
		setAddress(address);
		setMovieSessions(movieSessions);
		setLatitudeAndLongitudeFromAddress();
		setCinemaAuditoriums(cinemaAuditoriums);
	}

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

	public Set<Showtime> getMovieSessions() {
		return movieSessions;
	}

	public void setMovieSessions(Set<Showtime> movieSessions) {
		this.movieSessions = movieSessions;
	}

	public void setCinemaAuditoriums(Set<Auditorium> cinemaAuditoriums) {
		this.cinemaAuditoriums = cinemaAuditoriums;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	private void setLatitudeAndLongitudeFromAddress() {
		// Koordinatas iegust no adreses
		GeoApiContext context = new GeoApiContext.Builder().apiKey("AIzaSyBwjphxymy_3q9dDmj8E7lyr6fB9O-B49w").build();
		GeocodingResult[] results = new GeocodingResult[0];
		try {
			results = GeocodingApi.geocode(context, address).await();
		} catch (ApiException | InterruptedException | IOException e) {
			e.printStackTrace();
		}
		latitude = results[0].geometry.location.lat;
		longitude = results[0].geometry.location.lng;
	}

	double getLatitude() {
		return latitude;
	}

	double getLongitude() {
		return longitude;
	}

	public Set<Auditorium> getCinemaAuditoriums() {
		return cinemaAuditoriums;
	}

}
