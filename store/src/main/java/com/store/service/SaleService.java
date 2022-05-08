package com.store.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import com.store.dto.sale.SaleDTO;
import com.store.dto.sale.SaleMapper;
import com.store.entity.SaleItems;
import com.store.entity.Customer;
import com.store.entity.Sale;
import com.store.repository.SaleRepository;

@Service
public class SaleService {

	public final SaleRepository saleRepository;
	public final SaleItemsService saleItemsService;
	public final CustomerService customerService;
	public final ProductService productService;
	

	public SaleService(SaleRepository saleRepository, @Lazy SaleItemsService saleItemsService,
			CustomerService customerService, ProductService productService) {
		this.saleRepository = saleRepository;
		this.saleItemsService = saleItemsService;
		this.customerService = customerService;
		this.productService = productService;
	}

	public synchronized Sale saveSale(Sale sale) {
		
		boolean validStock = true;
		StringBuilder productsShort = new StringBuilder();
		
		for (SaleItems saleItems : sale.getSaleItems()) {
			if (saleItems.getProduct().getProductStock() < saleItems.getProductAmount()) {
				validStock = false;
				productsShort.append(saleItems.getProduct().getName());
				productsShort.append("\n");
			} else {
				productService.updateProductStockAfterSale(saleItems.getProduct().getId(), saleItems.getProductAmount());
			}
		}
		
		if(validStock) {
			sale = saleRepository.save(sale);
			
			
		} else {
			sale.setStockShort(productsShort.toString());
		}
		
		return sale;
	}

	public Sale getSaleById(Long saleId) {
		Optional<Sale> saleOptional = saleRepository.findById(saleId);
		Sale sale = saleOptional.get();
		return sale;
	}

	public List<SaleDTO> getAllSalesByCustomerId(Long id) {

		Customer customer = customerService.getCustomerByIdUser(id);
		List<Sale> listOfSales = saleRepository.getByCustomer(customer);
		List<SaleDTO> saleDTO = new ArrayList<>();

		for (Sale sale : listOfSales) {
			saleDTO.add(SaleMapper.fromEntity(sale));
		}

		return saleDTO;

	}

}
