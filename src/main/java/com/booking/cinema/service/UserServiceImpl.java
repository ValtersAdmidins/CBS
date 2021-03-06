package com.booking.cinema.service;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.booking.cinema.model.Role;
import com.booking.cinema.model.User;
import com.booking.cinema.repositories.RoleRepository;
import com.booking.cinema.repositories.UserRepository;

@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	 
	@Override
	public void saveUser(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		user.setActive(1);
		Role userRole = roleRepository.findByRole("USER");
		user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
		userRepository.save(user);
	}

//	public User getCurrentUserById(Long userId) {
//
//		Authentication authentication = SecurityContextHolder.getContext()
//				.getAuthentication();
//		if (!(authentication instanceof AnonymousAuthenticationToken)) {
//
//			User user = (User) authentication.getPrincipal();
//			
//			return user;
//		}
//		return null;
//	}

}
