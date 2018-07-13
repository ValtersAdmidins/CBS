package com.booking.cinema.model;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

@Entity
@Table(name = "Users")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;

	private String name;
	private String surname;
	@NotBlank
	private String username;
	@NotBlank
	private String pass;

	public boolean isAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(boolean adminStatus) {
		this.adminStatus = adminStatus;
	}

	@NotBlank
	private String email;
	@NotBlank
	private boolean adminStatus;

	public User() {
		setName("DefaultName");
		setSurname("DefaultSurname");
		setUsername("DefaultUsername");
		setPass("DefaultPass");
		setEmail("default@gmail.com");
	}

	public User(String name, String surname, String username, String pass, String email, boolean status) {
		setName(name);
		setSurname(surname);
		setUsername(username);
		setPass(pass);
		setEmail(email);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		if (name.length() < 4) {
			this.name = "DefaultName";
		} else {
			this.name = name;
		}
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		if (surname.length() < 4) {
			this.surname = "DefaultSurname";
		} else {
			this.surname = surname;
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		if (username.length() < 4) {
			this.username = "DefaultUsername";
		} else {
			this.username = username;
		}
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		if (pass.length() < 6) {
			this.pass = "DefaultPass";
		} else {
			this.pass = pass;
		}
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		if (email.length() < 11) {
			this.email = "Defaultemail@gmail.com";
		} else {
			this.email = email;
		}
	}

	public boolean isValidEmailAddress(String email) {
		String ePattern = "^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\])|(([a-zA-Z\\-0-9]+\\.)+[a-zA-Z]{2,}))$";
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(ePattern);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}

}