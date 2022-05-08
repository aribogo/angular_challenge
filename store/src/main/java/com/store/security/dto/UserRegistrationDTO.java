package com.store.security.dto;

public class UserRegistrationDTO {

	private String username;
	private String password;
	private Long id_role;
	
	public UserRegistrationDTO(String username, String password, Long id_role) {
		this.username = username;
		this.password = password;
		this.id_role = id_role;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Long getId_role() {
		return id_role;
	}

	public void setId_role(Long id_role) {
		this.id_role = id_role;
	}
	
}
