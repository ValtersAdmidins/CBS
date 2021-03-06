package com.booking.cinema.model;

import java.io.IOException;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

@Entity
@Table(name = "cinema")
public class Cinema {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String address;

	private double latitude;
	
	private double longitude;
	//@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
	//public Set<Showtime> showtime;
	////@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL,  orphanRemoval = true )
	////private Set<Auditorium> auditorium;
	
	
	public Cinema() {

	}
    
	 

	public Cinema(String name, String address, double latitude,
			double longitude) {
		this.name = name;
		this.address = address;
		this.latitude = latitude;
		this.longitude = longitude;
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

	public double getLatitude() {
		return latitude;
	}

	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}

	public double getLongitude() {
		return longitude;
	}

	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}

	 

	public void setLatitudeAndLongitudeFromAddress() {
		// Koordinatas iegust no adreses
		GeoApiContext context = new GeoApiContext.Builder()
				.apiKey("AIzaSyBwjphxymy_3q9dDmj8E7lyr6fB9O-B49w").build();
		GeocodingResult[] results = new GeocodingResult[0];
		try {
			results = GeocodingApi.geocode(context, address).await();
		} catch (ApiException | InterruptedException | IOException e) {
			e.printStackTrace();
		}
		latitude = results[0].geometry.location.lat;
		longitude = results[0].geometry.location.lng;
	}

	@Override
	public String toString() {
		return "Cinema [id=" + id + ", name=" + name + ", address=" + address + ", latitude=" + latitude
				+ ", longitude=" + longitude + "]";
	}

	 

}