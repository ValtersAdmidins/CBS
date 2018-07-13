package com.booking.cinema.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
@Entity
@Table(name = "Tickets")
public class Ticket {

	@Id
	private int id;
	@NotBlank
	private int column;
	@NotBlank
	private int row;
	private Showtime showtime;
	private Date date;
	
	
	public Ticket(int id, int column, int row, Showtime showtime) {
		setColumn(column);
		setDate();
		setId(id);
		setRow(row);
		setShowtime(showtime);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		if (id < 0) {
			System.out.println("Column cannot be lower than 0");
		}
		else {
			this.id = id;
		}
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
	public Showtime getShowtime() {
		return showtime;
	}
	public void setShowtime(Showtime showtime) {
		if (showtime.equals(null)) {
			System.out.println("Parameter cannot be null");
		}
		else {
			this.showtime = showtime;
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
		return "Ticket [id=" + id + ", column=" + column + ", row=" + row + ", showtime=" + showtime + ", date=" + date
				+ "]";
	}
	
	
	
	
}
