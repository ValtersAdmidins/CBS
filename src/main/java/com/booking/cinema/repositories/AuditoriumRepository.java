package com.booking.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Auditorium;
 

@Repository
public interface AuditoriumRepository extends JpaRepository<Auditorium, Long>{

}