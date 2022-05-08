package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long>{

	
	@Query("SELECT DISTINCT p FROM Product p WHERE p.id = :id")
	Product findDistinct(@RequestParam("id") Long id);
}
