package com.booking.cinema.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Cinema;

@Repository
public interface CinemaRepository extends JpaRepository<Cinema, Long> {



}