package com.booking.cinema.model;

import java.util.ArrayList;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import com.booking.cinema.enums.AgeLimit;
import com.booking.cinema.enums.Genre;
import com.booking.cinema.enums.Language;

@Entity
public class Movie {
    @Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String title;
	private String plot;
	private AgeLimit ageLimit;
	private ArrayList<Genre> genres;
	private Language language;
	private Language subtitles;
	private double movieLength;

	public Movie() {

	}

	public Movie(String title, String plot, AgeLimit ageLimit,
			ArrayList<Genre> genres, Language language, Language subtitles,
			double movieLength) {
		setTitle(title);
		setPlot(plot);
		setAgeLimit(ageLimit);
		setGenres(genres);
		setLanguage(language);
		setSubtitles(subtitles);
		setMovieLength(movieLength);
	}
	
	public double getMovieLength() {
		return movieLength;
	}

	

	public void setMovieLength(double movieLength) {
		this.movieLength = movieLength;
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

	@Override
	public String toString() {
		return "Movie [id=" + id + ", title=" + title + ", plot=" + plot + ", ageLimit=" + ageLimit + ", genres="
				+ genres + ", language=" + language + ", subtitles=" + subtitles + ", movieLength=" + movieLength + "]";
	}

	

	 

}