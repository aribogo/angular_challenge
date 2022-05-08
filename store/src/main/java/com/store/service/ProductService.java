package com.store.service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.store.dto.product.ProductDTO;
import com.store.dto.product.ProductMapper;
import com.store.entity.Product;
import com.store.repository.ProductRepository;
import com.store.utility.FileUtility;

@Service
public class ProductService {
	
	private final ProductRepository productRepository;
	private final FileUtility fileU;

	public ProductService(ProductRepository productRepository, FileUtility fileU) {
		this.productRepository = productRepository;
		this.fileU = fileU;
	}
	
	/**
	 * Save product in database
	 * @param product
	 * @return
	 * @throws Exception 
	 */
	public Product saveProduct(byte[] file, Product product) throws Exception {
		
		Product productNew  = null;
		
		try {
			product.getDisplayImage().setFileFolder(product.getCustomer().getId().toString());
			productNew = productRepository.save(product);
		} catch (Exception e) {
			throw new Exception("Could not save product");
		}
		
		String path = product.getDisplayImage().getFileFolder() + "/" + product.getId();
		fileU.saveFile(file, path, product.getDisplayImage().getFileName());
		
		return productNew;
	}
	
	
	/**
	 * Get product in database by id
	 * @param id
	 * @return
	 */
	public Product getProductById(Long id) {
		Optional<Product> productOptional = productRepository.findById(id);
		Product product = productOptional.get();
		
		return product;
	}
	
	public Product getProductDistinctById(Long id) {
		Product product = productRepository.findDistinct(id);
		return product;
	}
	
	/**
	 * Gets product from database by id.
	 * @param id
	 * @return DTO with base64 image
	 */
	public ProductDTO getProductDTOById(Long id) {
		
		Product product = getProductById(id);
		ProductDTO dto = null;
		
		dto= ProductMapper.fromEntity(product);
		
		String path = product.getDisplayImage().getFileFolder() + "/" + product.getId();
		byte[] file = fileU.readFile(path, product.getDisplayImage().getFileName());

		dto.setBase64Image(Base64.getMimeEncoder().encodeToString(file));
		
		return dto;
	}
	
	/**
	 * List of products in database.
	 * @return
	 */
	public List<ProductDTO> getAllProducts() {
		
		List<Product> listOfProducts = productRepository.findAll();
		List<ProductDTO> listProductDTOs = new ArrayList<>();
		
		for (Product product : listOfProducts) {

			String path = product.getDisplayImage().getFileFolder() + "/" + product.getId();
			byte[] file = fileU.readFile(path, product.getDisplayImage().getFileName());

			ProductDTO productDTO = null;

			productDTO = ProductMapper.fromEntity(product);
			
		
		productDTO.setBase64Image(Base64.getMimeEncoder().encodeToString(file));

		listProductDTOs.add(productDTO);
		}

		return listProductDTOs;
	}
		

	/**
	 * Updates stock from product after sale.
	 * @param id
	 * @param amountBought
	 */
	public void updateProductStockAfterSale(Long id, Integer amountBought) {
		Product product = getProductById(id);
		Integer newStock = product.getProductStock() - amountBought;
		product.setProductStock(newStock);
		productRepository.save(product);
		
	}
}
