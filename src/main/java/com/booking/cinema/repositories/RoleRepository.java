package com.booking.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.booking.cinema.model.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{
}
