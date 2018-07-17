package com.booking.cinema.repository;

 import org.springframework.data.jpa.repository.JpaRepository;
 import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Ticket;

 @Repository
 public interface TicketRepository extends JpaRepository<Ticket, Long>{

 }