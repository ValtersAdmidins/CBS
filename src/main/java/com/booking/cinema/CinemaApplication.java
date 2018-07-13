package com.booking.cinema;

import java.awt.print.Book;
import java.util.HashSet;
import java.util.Set;

import javax.transaction.Transactional;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.booking.cinema.model.Auditorium;
import com.booking.cinema.model.Cinema;

@SpringBootApplication
@EnableAutoConfiguration
public class CinemaApplication {

	public static void main(String[] args) {
		SpringApplication.run(CinemaApplication.class, args);
	}
}
