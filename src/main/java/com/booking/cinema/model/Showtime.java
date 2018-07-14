//package com.booking.cinema.model;
//
//import java.sql.Date;
//
//import javax.persistence.Entity;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
//import javax.persistence.Id;
//import javax.persistence.Table;
//
//@Entity
//@Table(name = "showtimes")
//public class Showtime {
//
//	private Long id;
//	private Date dateAndTime;
//	//private Cinema cinema;
//
//	public Showtime() {
//
//	}
//
//	public Showtime(Date dateAndTime) {
//		this.dateAndTime = dateAndTime;
//	}
//
////	public Showtime(Date dateAndTime, Cinema cinema) {
////		this.dateAndTime = dateAndTime;
////		this.cinema = cinema;
////	}
//
//	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//	public Long getId() {
//		return id;
//	}
//
//	public void setId(Long id) {
//		this.id = id;
//	}
//
//	public Date getDateAndTime() {
//		return dateAndTime;
//	}
//
//	public void setDateAndTime(Date dateAndTime) {
//		this.dateAndTime = dateAndTime;
//	}
//
////	@ManyToOne
////    @JoinColumn(name = "cinema_id")
////	public Cinema getCinema() {
////		return cinema;
////	}
////
////	public void setCinema(Cinema cinema) {
////		this.cinema = cinema;
////	}
//
//}