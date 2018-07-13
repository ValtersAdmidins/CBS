package com.booking.cinema.model;


import com.google.maps.GeoApiContext;
import com.google.maps.GeocodingApi;
import com.google.maps.errors.ApiException;
import com.google.maps.model.GeocodingResult;

import com.booking.cinema.model.Showtime;

import java.io.IOException;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Cinemas")
public class Cinema
{
	
	@NotBlank
    private String name;
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    private String address;
    
    private double latitude;
    private double longitude;
    private ArrayList<Showtime> movieSession;
    private ArrayList<Auditorium> cinemaAuditoriums;

    public Cinema()
    {   	       
        setName("DefaultName");
        setAddress("DefaultAddress");
        setMovieSession(new ArrayList<>());
        setLatitudeAndLongitude();
        setCinemaAuditories(new ArrayList<>());
        
    }
    public Cinema(String name, String address, ArrayList<Showtime> movieSession, ArrayList<Auditorium> cinemaAuditoriums)
    {
        setName(name);
        setAddress(address);
        setMovieSession(movieSession);
        setLatitudeAndLongitude();
        setCinemaAuditories(cinemaAuditoriums);
    }

    String getName()
    {
        return name;
    }

    private void setName(String name)
    {
        if(name.length()<4)
        {
            this.name="Cinema";
        }
        else
        {
            this.name = name;
        }
    }

    int getId()
    {
        return id;
    }

    private void setId(int id)
    {
        if(id>0)
        {
            this.id = id;
        }
        else
        {
            this.id = 0;
        }
        //Id vajadzetu panemt no datubazes.
    }

    String getAddress()
    {
        return address;
    }

    private void setAddress(String address)
    {
        if(address.length()<5)
        {
            this.address="Ventspils";
        }
        else
        {
            this.address = address;
        }
    }

    private void setLatitudeAndLongitude()
    {
        //Koordinatas iegust no adreses
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey("AIzaSyBwjphxymy_3q9dDmj8E7lyr6fB9O-B49w")
                .build();
        GeocodingResult[] results = new GeocodingResult[0];
        try
        {
            results = GeocodingApi.geocode(context,
                    address).await();
        }
        catch (ApiException | InterruptedException | IOException e)
        {
            e.printStackTrace();
        }
        latitude = results[0].geometry.location.lat;
        longitude = results[0].geometry.location.lng;
    }
    double getLatitude()
    {
        return latitude;
    }
    double getLongitude()
    {
        return longitude;
    }

    ArrayList<Showtime> getMovieSession() {
        return movieSession;
    }

    private void setMovieSession(ArrayList<Showtime> movieSession) {
        this.movieSession = movieSession;
    }

    ArrayList<Auditorium> getCinemaAuditories() {
        return cinemaAuditoriums;
    }

    private void setCinemaAuditories(ArrayList<Auditorium> cinemaAuditories) {
        this.cinemaAuditoriums = cinemaAuditories;
    }
    private String getCoordinatesFromAddress()
    {
        return "temporary";
    }
}
