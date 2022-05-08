package com.store.controller;

import java.util.Base64;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.product.ProductDTO;
import com.store.dto.product.ProductMapper;
import com.store.entity.Customer;
import com.store.entity.Product;
import com.store.security.entity.User;
import com.store.service.CustomerService;
import com.store.service.ProductService;

@RestController
@RequestMapping("v1/product")
public class ProductController {
	
	private final ProductService productService;
	private final CustomerService customerService;
	

	public ProductController(ProductService productService, CustomerService customerService) {
		this.productService = productService;
		this.customerService = customerService;
	}
	
	/**
	 * Save product in database.
	 * @param dto
	 * @return
	 */
	@PostMapping(produces = "application/json")
	public ResponseEntity<?> saveProduct(@RequestBody ProductDTO dto){
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User principal = (User) authentication.getPrincipal();
		
		Customer customer = customerService.getCustomerByIdUser(principal.getId());
		Product product = ProductMapper.fromDTO(dto);
		product.setCustomer(customer);
		Product productSaved = null;
		
		try {
			byte[] imageByte = Base64.getMimeDecoder().decode(dto.getBase64Image());
			productSaved = productService.saveProduct(imageByte, product);
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		} 
		
		return ResponseEntity.ok(ProductMapper.fromEntity(productSaved));
		
	}
	
	/**
	 * Get all products from database.
	 * @return
	 */
	@GetMapping
	public ResponseEntity<?> getAllProducts(){
		try {
			return ResponseEntity.ok(productService.getAllProducts());
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
	}
	
	@GetMapping("{id}")
	public ResponseEntity<?> getProductById(@PathVariable Long id){
		try {
			return ResponseEntity.ok(productService.getProductDTOById(id));
		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
	}
	
	

}
