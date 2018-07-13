package com.booking.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Showtime;

@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long>{

}