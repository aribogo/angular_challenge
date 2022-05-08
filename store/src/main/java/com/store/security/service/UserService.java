package com.store.security.service;

import java.util.Optional;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.store.security.entity.User;
import com.store.security.repository.UserRepository;

@Service
public class UserService implements UserDetailsService{

	private UserRepository userRepository;

	public UserService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	/**
	 * Saves user in the database
	 * 
	 * @param user
	 * @return
	 */
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	/**
	 * Gets database user by user name.
	 * 
	 * @param username
	 * @return
	 */
	public User getUserByUsername(String username) {
		Optional<User> optional = userRepository.findByUsername(username);

		if (optional.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}

		return optional.get();
	}

	/**
	 * Gets database user by id.
	 * 
	 * @param id
	 * @return
	 */
	public User getUserById(Long id) {
		Optional<User> optional = userRepository.findById(id);

		if (optional.isEmpty()) {
			throw new UsernameNotFoundException("User not found");
		}

		return optional.get();
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return getUserByUsername(username);
	}
}
