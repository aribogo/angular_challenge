package com.store.entity;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_sale")
public class Sale {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "sale_date")
	@NotNull
	private LocalDate saleDate;
	
	@Column(name = "total_amount")
	@NotNull
	private BigDecimal totalAmount;
	
	@Column(name = "zip_code")
	@NotEmpty
	private String zipCode;
	
	@ManyToOne
	private Customer customer;
	
	@OneToMany(mappedBy = "sale", cascade = CascadeType.ALL)
	private Set<SaleItems> saleItems;
	
	@Transient
	private String stockShort;
	

	public Sale(Long id, LocalDate saleDate, BigDecimal totalAmount, String zipCode,
			Customer customer) {
		this.id = id;
		this.saleDate = saleDate;
		this.totalAmount = totalAmount;
		this.zipCode = zipCode;
		this.customer = customer;
	}
	

	public Sale(Long id, BigDecimal totalAmount, String zipCode) {
		this.id = id;
		this.totalAmount = totalAmount;
		this.zipCode = zipCode;
	}




	public Sale() {
		super();
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public LocalDate getSaleDate() {
		return saleDate;
	}


	public void setSaleDate(LocalDate saleDate) {
		this.saleDate = saleDate;
	}

	public BigDecimal getTotalAmount() {
		return totalAmount;
	}


	public void setTotalAmount(BigDecimal totalAmount) {
		this.totalAmount = totalAmount;
	}


	public String getZipCode() {
		return zipCode;
	}


	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	public Customer getCustomer() {
		return customer;
	}


	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Set<SaleItems> getSaleItems() {
		return saleItems;
	}


	public void setSaleItems(Set<SaleItems> saleItems) {
		this.saleItems = saleItems;
	}


	public String getStockShort() {
		return stockShort;
	}


	public void setStockShort(String stockShort) {
		this.stockShort = stockShort;
	}
	
}
