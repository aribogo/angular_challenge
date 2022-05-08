package com.store.dto.Customer;

import com.store.entity.Customer;
import com.store.security.entity.User;
import com.store.security.service.UserService;

public class CustomerMapperDTO {
	

	/**
	 * Transforms customerDTO in customer.
	 * @param dto
	 * @return
	 */
	public static Customer fromDTO(CustomerDTO dto) {
		return new Customer(null, dto.getName(), dto.getCpf(), dto.getEmail(), dto.getUserId());
	}
	
	
	/**
	 * Transforms customerDTO with name as only variable in Customer.
	 * @param dto
	 * @return
	 */
	public static Customer fromDTOupdate(CustomerDTO dto) {
		return new Customer(dto.getName());
	}
	
	/**
	 * Transforms customer in customerDTO with name and email.
	 * @param dto
	 * @return
	 */
	public static CustomerDTO fromEntity(Customer customer) {
		return new CustomerDTO(customer.getName(), customer.getEmail());
	}
	
	/**
	 * Transforms customer in customerDTO with all information.
	 * @param dto
	 * @return
	 */
	public static CustomerDTO fromEntityGetById(Customer customer, User user) {
		return new CustomerDTO(customer.getName(), customer.getCpf(), customer.getEmail(), user.getRole().getName());
	}

}
