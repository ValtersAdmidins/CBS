package com.booking.cinema.services;

import com.booking.cinema.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
}
