package com.booking.cinema.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cinema")
public class Cinema {

	private Long id;
	private String name;
	private Set<Auditorium> auditoriums;
	private Set<Showtime> showtimes;

	public Cinema() {

	}

	public Cinema(String name) {
		this.name = name;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
	public Set<Auditorium> getAuditoriums() {
		return auditoriums;
	}

	public void setAuditoriums(Set<Auditorium> auditoriums) {
		this.auditoriums = auditoriums;
	}

	@OneToMany(mappedBy = "cinema", cascade = CascadeType.ALL)
	public Set<Showtime> getShowtimes() {
		return showtimes;
	}

	public void setShowtimes(Set<Showtime> showtimes) {
		this.showtimes = showtimes;
	}

	@Override
	public String toString() {
		String result = String.format("Cinema[id=%d, name='%s']%n", id, name);
		if (auditoriums != null) {
			for (Auditorium auditorium : auditoriums) {
				result += String.format("Auditorium[id=%d, name='%s']%n", auditorium.getId(), auditorium.getRoom());
			}
		}

		return result;
	}

}
