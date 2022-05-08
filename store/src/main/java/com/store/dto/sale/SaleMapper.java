package com.store.dto.sale;

import com.store.entity.Sale;

public class SaleMapper {
	
	/**
	 * New sale from DTO's information.
	 * @param dto
	 * @return
	 */
	public static  Sale fromDTO(SaleDTO dto) {
		return new Sale(null, dto.getTotalAmount(), dto.getZipCode());
	}
	
	/**
	 * New DTO from sale's information.
	 * @param sale
	 * @return
	 */
	public static SaleDTO fromEntity(Sale sale) {
		return new SaleDTO(sale.getId() ,sale.getSaleDate(), sale.getTotalAmount(), sale.getZipCode(), sale.getCustomer().getName());
	}
	
	/**
	 * New DTO from sale's information when stock was insufficient.
	 * @param sale
	 * @return
	 */
	public static SaleDTO fromEntityUnnableToSave(Sale sale) {
		return new SaleDTO(sale.getStockShort());
	}
	
	

}
