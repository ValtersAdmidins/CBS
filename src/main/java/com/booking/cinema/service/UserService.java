package com.booking.cinema.service;

import com.booking.cinema.model.User;

public interface UserService {
	public User findUserByEmail(String email);
	public void saveUser(User user);
//	public User getCurrentUser();				//'????bddddddddddd
}
