package com.store.dto;

public class ItemDTO {

	private Long id;
	private Integer quantity;
	
	
	public ItemDTO(Long id, Integer quantity) {
		this.id = id;
		this.quantity = quantity;
	}

	public ItemDTO() {
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	
	
	
	
	
}
