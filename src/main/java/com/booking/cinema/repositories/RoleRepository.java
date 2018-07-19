package com.booking.cinema.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.booking.cinema.model.Role;

@Repository("roleRepository")
public interface RoleRepository extends JpaRepository<Role, Integer>{
	Role findByRole(String role);
	@Modifying
	 @Query(value = "select role_id from user_role where user_id=?1", nativeQuery = true)
	 public int showUserRole(Long user_id);
}
