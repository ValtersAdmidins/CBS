package com.booking.cinema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long>{
	
//	//@Query("SELECT c FROM Cinemas c WHERE p.Name = id")
//	public List<Cinema> findCinemasWhereMovieIsShowing(@Param("id") Long id);
//	
//	@Query("SELECT c FROM Cinemas c WHERE p.Name = id")
//	public List<Cinema> findAllMoviesInACinema(@Param("id") Long id);
}
