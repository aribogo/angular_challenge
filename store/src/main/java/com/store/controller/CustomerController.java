package com.store.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.store.dto.Customer.CustomerDTO;
import com.store.dto.Customer.CustomerMapperDTO;
import com.store.entity.Customer;
import com.store.repository.CpfDAO;
import com.store.security.entity.User;
import com.store.security.service.UserService;
import com.store.service.CustomerService;


@RestController
@RequestMapping("v1/customer")
public class CustomerController {

	private final CustomerService customerService;
	private final UserService userService;
	private final CpfDAO cpfDAO;

	public CustomerController(CustomerService customerService, UserService userService, CpfDAO cpfDAO) {
		this.customerService = customerService;
		this.userService = userService;
		this.cpfDAO = cpfDAO;
	}

	/**
	 * Tries to Save customer and return customer's information or gives an error.
	 * @param dto
	 * @return
	 */
	@PostMapping
	public ResponseEntity<?> saveCustomer(@RequestBody CustomerDTO dto){
		
		boolean isCpfValid = cpfDAO.getCpf(dto.getCpf());
		
		if(isCpfValid) {
			Customer customer = null;
		
			try {
				customer = customerService.saveCustomer(CustomerMapperDTO.fromDTO(dto));
			} catch (Exception e) {
				return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
			}
		
			return ResponseEntity.ok(CustomerMapperDTO.fromEntity(customer));	
		} else {
			return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).build();
		}
	}


	/**
	 * Tries to get customer by id and return customer's information or gives an
	 * error.
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping()
	public ResponseEntity<?> getCustomer() {

		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		User principal = (User) authentication.getPrincipal();

		Customer customer = new Customer();

		try {
			customer = customerService.getCustomerByIdUser(principal.getId());

		} catch (Exception e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}

		return ResponseEntity.ok(CustomerMapperDTO.fromEntityGetById(customer, principal));

	}

}
