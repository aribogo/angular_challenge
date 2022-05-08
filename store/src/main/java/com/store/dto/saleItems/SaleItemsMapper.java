package com.store.dto.saleItems;

import com.store.dto.product.ProductMapper;
import com.store.dto.sale.SaleMapper;
import com.store.entity.SaleItems;

public class SaleItemsMapper {
	
	/**
	 * New cartItems from DTO's information.
	 * @param dto
	 * @return
	 */
	public static SaleItems fromDTO(SaleItemsDTO dto) {
		return new SaleItems(ProductMapper.fromDTO(dto.getProduct()), dto.getProductAmount());
	}
	
	/**
	 * New DTO from cartItems' information.
	 * @param sale
	 * @return
	 */
	public static SaleItemsDTO fromEntity(SaleItems saleItems) {
		return new SaleItemsDTO(SaleMapper.fromEntity(saleItems.getSale()), ProductMapper.fromEntity(saleItems.getProduct()) ,
				saleItems.getProductAmount(), saleItems.getTotalCost());
	}

}
