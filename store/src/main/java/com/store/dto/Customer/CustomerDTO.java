package com.store.dto.Customer;

import javax.persistence.Column;
import javax.validation.constraints.NotEmpty;

public class CustomerDTO {

	private String name;
	private String cpf;
	private String email;
	private Long userId;

	public CustomerDTO(String name, String cpf, String email, Long userId, String role) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.userId = userId;
	}

	public CustomerDTO(String name, String cpf, String email) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}

	public CustomerDTO(String name, String cpf, String email, Long userId) {
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.userId = userId;
	}
	
	public CustomerDTO(String name, String email) {
		super();
		this.name = name;
		this.email = email;
	}

	public CustomerDTO(String name, String cpf, String email, String role) {
		super();
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}

	public CustomerDTO() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	
	
}
