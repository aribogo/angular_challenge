package com.store.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_customer")
public class Customer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	@NotEmpty(message = "Can not be blank")
	private String name;
	
	@Column(name = "cpf")
	@NotEmpty
	private String cpf;
	
	@Column(name = "email")
	@NotEmpty
	private String email;
	
	@Column(name = "id_user")
	@NotNull
	private Long userId;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Sale> sales;
	
	@OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
	private Set<Product> products;
	
	public Customer() {
		
	}

	public Customer(Long id, String name,
			String cpf, @NotEmpty String email, Long userId) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
		this.userId = userId;
	}

	

	public Customer(String name) {
		this.name = name;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
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

	public Set<Sale> getSales() {
		return sales;
	}

	public void setSales(Set<Sale> sales) {
		this.sales = sales;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}


	
}
