package com.store.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import com.store.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

	/**
	 * Get customer by user's id.
	 * @param userId
	 * @return
	 */
	@Query(value = "SELECT c FROM Customer c WHERE c.userId = :userId")
	Customer getByUserid(@RequestParam("userId") Long userId);
	
}
