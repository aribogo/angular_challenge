package com.store.entity;

import java.math.BigDecimal;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tb_product")
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Long id;
	
	@Column(name = "name")
	@NotEmpty
	private String name;
	
	@Column(name = "description")
	@NotEmpty
	private String description;
	
	@Column(name = "measurement_unit")
	@NotEmpty
	private String measurementUnit;
	
	@Column(name = "price")
	@NotNull(message = "Can not be null")
	private BigDecimal price;
	
	@Column(name = "product_stock")
	@NotNull(message = "Can not be null")
	private Integer productStock;
	
	@Embedded
	private Image displayImage;
	
	@OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
	private Set<SaleItems> saleItems;
	
	@ManyToOne
	private Customer customer;
	
	
	public Product(Long id, String name, String description, String measurementUnit,
			BigDecimal price, Integer productStock, Image displayImage) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.measurementUnit = measurementUnit;
		this.price = price;
		this.productStock = productStock;
		this.displayImage = displayImage;
	}

	public Product() {

	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getMeasurementUnit() {
		return measurementUnit;
	}

	public void setMeasurementUnit(String measurementUnit) {
		this.measurementUnit = measurementUnit;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public Integer getProductStock() {
		return productStock;
	}

	public void setProductStock(Integer productStock) {
		this.productStock = productStock;
	}

	public Image getDisplayImage() {
		return displayImage;
	}

	public void setDisplayImage(Image displayImage) {
		this.displayImage = displayImage;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}	
	
	
	
}
