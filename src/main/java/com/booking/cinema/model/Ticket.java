package com.booking.cinema.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "ticket")
public class Ticket {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(nullable = false, length = 5)
	private int columnn;
	@Column(nullable = false, length = 5)
	private int roww;
	@Column(length = 5)
	private double price;

	@ManyToOne
	@JoinColumn(name = "user_id")
	public User user;
	@Column
	private Date date;
	@ManyToOne
	@JoinColumn(name = "showtime_id")
	public Showtime showtime;

	public Ticket() {
		 
	}
	
	public Ticket(long id, int columnn, int roww, double price) {
		setId(id);
		setColumn(columnn);
		setRow(roww);
		setPrice(price);
		 
	}

	public Showtime getShowtime() {
		return showtime;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setShowtime(Showtime showtime) {
		this.showtime = showtime;
	}

	

	private void setPrice(double price) {
		if (price < 0.01) {
			System.out.println("Column cannot be lower than 0");
			this.price = 4.50;
		} else {
			this.price = price;
		}
	}

	public double getPrice() {
		return price;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		if (id < 0) {
			System.out.println("Column cannot be lower than 0");
		} else {
			this.id = id;
		}
	}

	public int getColumn() {
		return columnn;
	}

	public void setColumn(int columnn) {
		if (columnn < 0) {
			System.out.println("Column cannot be lower than 1");
		} else {
			this.columnn = columnn;
		}
	}

	public int getRow() {
		return roww;
	}

	public void setRow(int roww) {
		if (roww < 0) {
			System.out.println("Row cannot be lower than 1");
		} else {
			this.roww = roww;
		}
	}

	  

	@Override
	public String toString() {
		return "Ticket [id=" + id + ", column=" + columnn + ", row=" + roww + " + " + "]";
	}

}