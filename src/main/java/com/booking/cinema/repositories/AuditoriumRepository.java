package com.booking.cinema.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Auditorium;
import com.booking.cinema.model.Showtime;

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long> {
 
	
	
	@Query("select a from Auditorium a where a.cinema_id = ?1")
    public List<Auditorium> findAllAuditoriumsInCinema(Long cinema_id);
}
