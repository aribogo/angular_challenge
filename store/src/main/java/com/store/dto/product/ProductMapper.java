package com.store.dto.product;

import com.store.dto.image.ImageMapper;
import com.store.entity.Image;
import com.store.entity.Product;

public class ProductMapper {
	
	/**
	 * New product from DTO's information.
	 * @param dto
	 * @return
	 */
	public static Product fromDTO(ProductDTO dto) {
		Image image = new Image();
		image.setFileName(dto.getName() + ".jpg");
		
		return new Product(null, dto.getName() ,dto.getDescription(), dto.getMeasurementUnit(),
				dto.getPrice(), dto.getProductStock(), image);
	}
	
	/**
	 * New DTO from product's information.
	 * @param sale
	 * @return
	 */
	public static ProductDTO fromEntity(Product product) {
		return new ProductDTO(product.getId(), product.getName() ,product.getDescription(), product.getMeasurementUnit(), product.getPrice(), product.getProductStock(),
				product.getCustomer().getName(), ImageMapper.fromEntity(product.getDisplayImage()));
	}
	
	
	
}
