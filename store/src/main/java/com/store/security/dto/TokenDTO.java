package com.store.security.dto;

public class TokenDTO {
	
	private String token;

	public TokenDTO(String token) {
		this.token = token;
	}

	public TokenDTO() {

	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
}
