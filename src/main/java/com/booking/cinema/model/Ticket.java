 package com.booking.cinema.model;

 import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
 import javax.persistence.Entity;
 import javax.persistence.GeneratedValue;
 import javax.persistence.GenerationType;
 import javax.persistence.Id;
 import javax.persistence.Table;
 import javax.validation.constraints.NotBlank;
 @Entity
 public class Ticket {

 @Id
 @GeneratedValue(strategy = GenerationType.IDENTITY)
 private long id;
 @Column(nullable = false, length = 5)
 private int column;
 @Column(nullable = false, length = 5)
 private int row;
 private double price;
 private Set<Movie> movies;
 private Set<Cinema> cinemas;
 private Set<Auditorium> auditorium;
  @Column
 private Date date;


 public Ticket(long id, int column, int row, double price, Date date) {
	 setId(id);
	 setColumn(column);
	 setRow(row);
	 setPrice(price);
 	 setDate();
 
 
 
 }

 private void setPrice(double price) {
	 if (price < 0.01) {
		 System.out.println("Column cannot be lower than 0");
		 this.price = 4.50; 
	 	}
		 else {
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
 /*
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
 }*/
 public Date getDate() {
 return date;
 }
 public void setDate() {
 this.date = new Date();
 }

 @Override
 public String toString() {
 return "Ticket [id=" + id + ", column=" + column + ", row=" + row + " + "
 + "]";
 }




 }