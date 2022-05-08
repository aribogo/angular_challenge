package com.store.dto;

import java.util.List;

public class SaleAndItemsDTO {

	private List<ItemDTO> listOfProducts;
	
	private String zipCode;

	public SaleAndItemsDTO(List<ItemDTO> listOfProducts, String zipCode) {
		this.listOfProducts = listOfProducts;
		this.zipCode = zipCode;
	}

	public SaleAndItemsDTO() {
	}

	public List<ItemDTO> getListOfProducts() {
		return listOfProducts;
	}

	public void setListOfProducts(List<ItemDTO> listOfProducts) {
		this.listOfProducts = listOfProducts;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}


	
}
