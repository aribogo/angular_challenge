package com.store.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.store.entity.SaleItems;
import com.store.entity.Sale;
import com.store.repository.SaleItemsRepository;

@Service
public class SaleItemsService {
	
	public final SaleItemsRepository saleItemsRepository;
	public final ProductService productService;
	public final SaleService saleService;

	public SaleItemsService(SaleItemsRepository saleItemsRepository, ProductService productService, SaleService saleService) {
		this.saleItemsRepository = saleItemsRepository;
		this.productService = productService;
		this.saleService = saleService;
	}
	
	public List<SaleItems> getAllSaleItemsBySaleId(Long saleId) {
		Sale sale = saleService.getSaleById(saleId);
		
		List<SaleItems> saleItems = saleItemsRepository.getBySale(sale);
		
		
		
		return saleItems;
	}
	
	
	

}
