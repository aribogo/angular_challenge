package com.store.dto.saleItems;

import java.math.BigDecimal;

import com.store.dto.product.ProductDTO;
import com.store.dto.sale.SaleDTO;

public class SaleItemsDTO {
	
	private SaleDTO sale;
	private ProductDTO product;
	private Integer productAmount;
	private BigDecimal totalCost;
	
	
	public SaleItemsDTO(ProductDTO product, Integer productAmount) {
		this.product = product;
		this.productAmount = productAmount;
	}

	public SaleItemsDTO(SaleDTO sale, ProductDTO product, Integer productAmount, BigDecimal totalCost) {
		this.sale = sale;
		this.product = product;
		this.productAmount = productAmount;
		this.totalCost = totalCost;
	}
	
	

	public SaleItemsDTO() {
	}

	public SaleDTO getSale() {
		return sale;
	}

	public void setSale(SaleDTO sale) {
		this.sale = sale;
	}

	public ProductDTO getProduct() {
		return product;
	}

	public void setProduct(ProductDTO product) {
		this.product = product;
	}

	public Integer getProductAmount() {
		return productAmount;
	}

	public void setProductAmount(Integer productAmount) {
		this.productAmount = productAmount;
	}

	public BigDecimal getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(BigDecimal totalCost) {
		this.totalCost = totalCost;
	}
	
	
	
}
