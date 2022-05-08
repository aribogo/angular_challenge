package com.store.dto.sale;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SaleDTO {

	private Long id;
	private LocalDate saleDate;
	private BigDecimal totalAmount;
	private String zipCode;
	private String customerName;
	private String stockShort;
	
	public SaleDTO(BigDecimal totalAmount, String zipCode) {
		this.totalAmount = totalAmount;
		this.zipCode = zipCode;
	}
	
	public SaleDTO(String stockShort) {
		this.stockShort = stockShort;
	}



	public SaleDTO(Long id, LocalDate saleDate, BigDecimal totalAmount, String zipCode, String customerName) {
		this.id = id;
		this.saleDate = saleDate;
		this.totalAmount = totalAmount;
		this.zipCode = zipCode;
		this.customerName = customerName;
	}

	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public SaleDTO() {
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


	public String getCustomerName() {
		return customerName;
	}


	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}

	public String getStockShort() {
		return stockShort;
	}

	public void setStockShort(String stockShort) {
		this.stockShort = stockShort;
	}

}
