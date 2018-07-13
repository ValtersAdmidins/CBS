package com.booking.cinema.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "Tickets")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	private Long movieid;
	private Long showtimeId;
	
	
	public Long getMovieid() {
		return movieid;
	}

	public void setMovieid(Long movieid) {
		this.movieid = movieid;
	}

	public Long getShowtimeId() {
		return showtimeId;
	}

	public void setShowtimeId(Long showtimeId) {
		this.showtimeId = showtimeId;
	}

	@NotBlank
	private int column;
	@NotBlank
	private int row;
	
	private Date date;
	
	
	public Ticket(Long id, int column, int row) {
		setColumn(column);
		setDate();
		setId(id);
		setRow(row);
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getColumn() {
		return column;
	}
	public void setColumn(int column) {
		if (column < 0) {
			System.out.println("Column cannot be lower than 1");
		}
		else {
			this.column = column;
		}
	}
	public int getRow() {
		return row;
	}
	public void setRow(int row) {
		if (row < 0) {
			System.out.println("Row cannot be lower than 1");
		}
		else {
			this.row = row;
		}
	}
	
	public Date getDate() {
		return date;
	}
	public void setDate() {
		this.date = new Date();
	}

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", column=" + column + ", row=" + row + ", date=" + date
				+ "]";
	}
	
	
	
	
}
