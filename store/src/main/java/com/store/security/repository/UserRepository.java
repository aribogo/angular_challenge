package com.store.security.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.store.security.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

	/**
	 * Gets user by username.
	 * @param username
	 * @return
	 */
	Optional<User> findByUsername(String email);
}
