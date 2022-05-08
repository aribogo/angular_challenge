package com.store.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="tb_cart_items")
public class SaleItems {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@ManyToOne
	@NotNull
	private Sale sale;
	
	@ManyToOne
	//@JoinColumn(name = "product_id")
	@NotNull
	private Product product;
	
	@NotNull
	@Column(name="product_amount")
	private Integer productAmount;
	
	@NotNull
	@Column(name="total_cost")
	private BigDecimal totalCost;

	public SaleItems(Long id, @NotNull Sale sale, @NotNull Product product, @NotNull Integer productAmount,
			@NotNull BigDecimal totalCost) {
		this.id = id;
		this.sale = sale;
		this.product = product;
		this.productAmount = productAmount;
		this.totalCost = totalCost;
	}	

	public SaleItems() {
	}

	public SaleItems(@NotNull Product product, @NotNull Integer productAmount) {
		this.product = product;
		this.productAmount = productAmount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Sale getSale() {
		return sale;
	}

	public void setSale(Sale sale) {
		this.sale = sale;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
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
