package com.store.dto.product;

import java.math.BigDecimal;

import com.store.dto.image.ImageDTO;
import com.store.entity.SaleItems;
import com.store.entity.Customer;

public class ProductDTO {
	
	private Long id;
	
	private String name;

	private String description;

	private String measurementUnit;

	private BigDecimal price;

	private Integer productStock;

	private String base64Image;

	private String nameCustomer;
	
	private ImageDTO image;


	public ProductDTO(Long id, String name, String description, String measurementUnit, BigDecimal price, Integer productStock,
			String nameCustomer, ImageDTO image) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.measurementUnit = measurementUnit;
		this.price = price;
		this.productStock = productStock;
		this.nameCustomer = nameCustomer;
		this.image = image;
		
	}

	public ProductDTO() {
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

	public String getBase64Image() {
		return base64Image;
	}

	public void setBase64Image(String base64Image) {
		this.base64Image = base64Image;
	}

	

	public String getNameCustomer() {
		return nameCustomer;
	}



	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public ImageDTO getImage() {
		return image;
	}

	public void setImage(ImageDTO image) {
		this.image = image;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	

}
