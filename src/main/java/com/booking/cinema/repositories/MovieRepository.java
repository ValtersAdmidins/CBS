package com.booking.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long>{

}
