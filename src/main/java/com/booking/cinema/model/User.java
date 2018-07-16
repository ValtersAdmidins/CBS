package com.booking.cinema.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {

	private Long id;

	private String firstname;
	private String lastname;
	private String username;
	private String email;
	private String password;
	private String repeatedPassword;
	private int adminStatus;

	// private Ticket ticket;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getRepeatedPassword() {
		return repeatedPassword;
	}
	public void setRepeatedPassword(String repeatedPassword) {
		this.repeatedPassword = repeatedPassword;
	}
	public int getAdminStatus() {
		return adminStatus;
	}
	public void setAdminStatus(int adminStatus) {
		this.adminStatus = adminStatus;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname="
				+ lastname + ", username=" + username + ", email=" + email
				+ ", password=" + password + ", repeatedPassword="
				+ repeatedPassword + ", adminStatus=" + adminStatus + "]";
	}
	
}

// package com.booking.cinema.model;
//
// import javax.persistence.*;
// import java.util.HashSet;
// import java.util.Set;
//
// @Entity
// public class User {
// @Id
// @GeneratedValue(strategy = GenerationType.IDENTITY)
// private Long id;
//
// @Column(nullable = false, length = 30, unique = true)
// private String username;
//
// @Column(length = 60)
// private String passwordHash;
//
// @Column(length = 100)
// private String fullName;
//
// //@OneToMany(mappedBy = "tickets")
// //private Set<Ticket> tickets = new HashSet<Ticket>();
//
// public Long getId() {
// return id;
// }
//
// public void setId(Long id) {
// this.id = id;
// }
//
// public String getUsername() {
// return username;
// }
//
// public void setUsername(String username) {
// this.username = username;
// }
//
// public String getPasswordHash() {
// return passwordHash;
// }
//
// public void setPasswordHash(String passwordHash) {
// this.passwordHash = passwordHash;
// }
//
// public String getFullName() {
// return fullName;
// }
//
// public void setFullName(String fullName) {
// this.fullName = fullName;
// }
//
//// public Set<Ticket> getTickets() {
//// return tickets;
//// }
////
//// public void setTickets(Set<Ticket> Tickets) {
//// this.tickets = tickets;
//// }
//
// public User() {
// }
//
// public User(String username, String fullName) {
// this.username = username;
// this.fullName = fullName;
// }
//
// public User(Long id, String username, String fullName) {
// this.id = id;
// this.username = username;
// this.fullName = fullName;
// }
//
// @Override
// public String toString() {
// return "User{" +
// "id=" + id +
// ", username='" + username + '\'' +
// ", passwordHash='" + passwordHash + '\'' +
// ", fullName='" + fullName + '\'' +
// '}';
// }
// }
