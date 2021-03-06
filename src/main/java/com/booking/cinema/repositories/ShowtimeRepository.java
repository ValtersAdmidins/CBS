package com.booking.cinema.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {
	
	@Query(value = "select * from Showtime where movie_id = ?1", nativeQuery = true)
    public List<Showtime> findAllShowtimesForMovie(Long movie_id);
	
	 @Modifying
	 @Query(value = "delete s from Showtime s where s.movie_id = ?1", nativeQuery = true)
	 public void deleteShowtimesByMovieId(Long movie_id);
	 
	 /*
	 @Modifying
	 @Query("delete from Showtime s where s.auditorium = ?1")
	 public void deleteShowtimesByAuditoriumId(Long auditorium_id);
	 
	 @Modifying
	 @Query("delete from Showtime s where s.cinema = ?1")
	 public void deleteShowtimesByCinemaId(Long cinema_id);
	 
	 */
	 
	
}
