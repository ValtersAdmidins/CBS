package com.booking.cinema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {

	
	@Query("SELECT s FROM Showtime s WHERE s.movie_id = movie_id")
    public List<Showtime> findAllShowtimesForMovie(@Param("movie_id") Long movie_id);
	
}
