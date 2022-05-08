package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.entity.SaleItems;
import com.store.entity.Customer;
import com.store.entity.Sale;

@Repository
public interface SaleRepository extends JpaRepository<Sale, Long>{

	@Query(value = "SELECT s FROM Sale s WHERE s.customer = :customer")
	List<Sale> getByCustomer(@RequestParam("customer") Customer customer);
	
}
