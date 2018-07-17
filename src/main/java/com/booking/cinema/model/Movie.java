package com.booking.cinema.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.booking.cinema.enums.AgeLimit;
import com.booking.cinema.enums.Genre;
import com.booking.cinema.enums.Language;

@Entity
public class Movie {

	private Long id;

	private String title;
	private String plot;
	private AgeLimit ageLimit;
	private ArrayList<Genre> genres;
	private Language language;
	private Language subtitles;
	private int movieLengthMinutes;

	private Cinema cinema;

	public Movie() {

	}

	public Movie(String title, String plot, AgeLimit ageLimit,
			ArrayList<Genre> genres, Language language, Language subtitles,
			int movieLengthMinutes) {
		setTitle(title);
		setPlot(plot);
		setAgeLimit(ageLimit);
		setGenres(genres);
		setLanguage(language);
		setSubtitles(subtitles);
		setMovieLengthMinutes(movieLengthMinutes);
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getPlot() {
		return plot;
	}

	public void setPlot(String plot) {
		this.plot = plot;
	}

	public AgeLimit getAgeLimit() {
		return ageLimit;
	}

	public void setAgeLimit(AgeLimit ageLimit) {
		this.ageLimit = ageLimit;
	}

	public ArrayList<Genre> getGenres() {
		return genres;
	}

	public void setGenres(ArrayList<Genre> genres) {
		this.genres = genres;
	}

	public Language getLanguage() {
		return language;
	}

	public void setLanguage(Language language) {
		this.language = language;
	}

	public Language getSubtitles() {
		return subtitles;
	}

	public void setSubtitles(Language subtitles) {
		this.subtitles = subtitles;
	}

	public int getMovieLengthMinutes() {
		return movieLengthMinutes;
	}

	public void setMovieLengthMinutes(int movieLengthMinutes) {
		this.movieLengthMinutes = movieLengthMinutes;
	}

	@ManyToOne
	@JoinColumn(name = "cinema_id")
	public Cinema getCinema() {
		return cinema;
	}

	public void setCinema(Cinema cinema) {
		this.cinema = cinema;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", plot=" + plot
				+ ", ageLimit=" + ageLimit + ", genres=" + genres
				+ ", language=" + language + ", subtitles=" + subtitles
				+ ", movieLength=" + movieLengthMinutes + ", cinema=" + cinema + "]";
	}

}