package com.store.controller;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.ItemDTO;
import com.store.dto.SaleAndItemsDTO;
import com.store.dto.sale.SaleDTO;
import com.store.dto.sale.SaleMapper;
import com.store.entity.Customer;
import com.store.entity.Product;
import com.store.entity.Sale;
import com.store.entity.SaleItems;
import com.store.repository.CepDAO;
import com.store.security.entity.User;
import com.store.service.CustomerService;
import com.store.service.ProductService;
import com.store.service.SaleService;

@RestController
@RequestMapping("v1/sales")
public class SaleController {

	public final SaleService saleService;
	public final ProductService productService;
	public final CustomerService customerService;
	public final CepDAO zipCodeDAO;

	public SaleController(SaleService saleService, ProductService productService, CustomerService customerService, CepDAO zipCodeDAO) {
		this.saleService = saleService;
		this.productService = productService;
		this.customerService = customerService;
		this.zipCodeDAO = zipCodeDAO;
	}
	
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> saveSale(@RequestBody SaleAndItemsDTO dto) {
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User principal = (User) authentication.getPrincipal();
		
		boolean zip = zipCodeDAO.validZipCode(dto.getZipCode());
		
		if( !zip) {
			return ResponseEntity.badRequest().build();
		}
		
		BigDecimal finalValue = BigDecimal.ZERO;
		
		Customer customer = customerService.getCustomerByIdUser(principal.getId());
		
		
		Set<SaleItems> saleItems = new HashSet<>();
		Sale sale = new Sale();
		
		if(dto.getListOfProducts().isEmpty() || dto.getListOfProducts() == null) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		} else {
			for(ItemDTO product : dto.getListOfProducts()) {
				Product savedProduct = productService.getProductDistinctById(product.getId());
				SaleItems item = new SaleItems();
				item.setProduct(savedProduct);
				item.setProductAmount(product.getQuantity());
				
				BigDecimal totalCost = savedProduct.getPrice().multiply(BigDecimal.valueOf(product.getQuantity()));
				
				finalValue = finalValue.add(totalCost);
				
				item.setTotalCost(totalCost);
				
				item.setSale(sale);
				
				saleItems.add(item);
			}
			
			sale.setCustomer(customer);
			sale.setSaleDate(LocalDate.now());
			sale.setZipCode(dto.getZipCode());
			sale.setTotalAmount(finalValue);
			sale.setSaleItems(saleItems);
		}
		
		Sale saleNew = saleService.saveSale(sale);
		
		if(saleNew.getStockShort() == null || saleNew.getStockShort().isBlank() ) {
			return ResponseEntity.ok(SaleMapper.fromEntityUnnableToSave(saleNew));
		} else {
			return ResponseEntity.ok(SaleMapper.fromEntity(saleNew));
		}
	}
	
	@GetMapping
	public ResponseEntity<?> getAllSales(){
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User principal = (User) authentication.getPrincipal();
		Customer customer = customerService.getCustomerByIdUser(principal.getId());
		List<SaleDTO> salesDTO = new ArrayList<>();
		
		try {
			salesDTO = saleService.getAllSalesByCustomerId(customer.getId());
		} catch (Exception e) {
			return ResponseEntity.notFound().build();
		}
		
		return ResponseEntity.ok(salesDTO);
	}
	
}
