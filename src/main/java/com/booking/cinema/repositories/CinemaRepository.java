package com.booking.cinema.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Cinema;
import com.booking.cinema.model.Showtime;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {

	@Query("select s from Showtime s where s.movie = ?1")
    public List<Showtime> findAllShowtimesForMovie( Long movie_id);
	
	
}