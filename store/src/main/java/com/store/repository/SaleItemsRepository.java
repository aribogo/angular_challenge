package com.store.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.entity.SaleItems;
import com.store.entity.Sale;

@Repository
public interface SaleItemsRepository extends JpaRepository<SaleItems, Long> {

	@Query(value = "SELECT c FROM SaleItems c WHERE c.sale = :sale")
	List<SaleItems> getBySale(@RequestParam("sale") Sale sale);
	
}
