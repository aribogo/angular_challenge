package com.store.security.dto;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.store.security.entity.Role;
import com.store.security.entity.User;

public class UserMapper {

	/**
	 * Sets user based on user's DTO content.
	 * @param dto
	 * @return
	 */
	public static User fromDTO(UserRegistrationDTO dto) {

		Role role = new Role();
		role.setId(dto.getId_role());


		return new User(null, dto.getUsername(), new BCryptPasswordEncoder().encode(dto.getPassword()), role);
	}

	/**
	 * Sets user's DTO based on user's content.
	 * @param dto
	 * @return
	 */
	public static UserDTO fromEntity(User user) {

		return new UserDTO(user.getUsername(), user.getRole().getName());

	}
	
}
