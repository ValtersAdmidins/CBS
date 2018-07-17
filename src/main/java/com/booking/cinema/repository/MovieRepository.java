package com.booking.cinema.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Movie;

@Repository
public interface MovieRepository extends JpaRepository<Movie, Long> {

}
