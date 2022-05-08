package com.store.service;

import java.util.Optional;
import java.util.Random;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.store.entity.Customer;
import com.store.repository.CpfDAO;
import com.store.repository.CustomerRepository;
import com.store.security.entity.Role;
import com.store.security.entity.User;
import com.store.security.repository.RoleRepository;
import com.store.security.service.UserService;

@Service
public class CustomerService {

	private final CustomerRepository customerRepository;
	private final UserService userService;
	private final RoleRepository roleRepository;
	

	public CustomerService(CustomerRepository customerRepository, UserService userService, RoleRepository roleRepository) {
		this.customerRepository = customerRepository;
		this.userService = userService;
		this.roleRepository = roleRepository;
	}
	
	/**
	 * Saves customer and user in database
	 * @param customer
	 * @param roleName
	 * @return
	 */
	public Customer saveCustomer(Customer customer) {
		
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String randomPass = alphaNumericString(10);
		System.out.println(randomPass);
		Role role = roleRepository.getByName("CUSTOMER");
		User user = new User(null, customer.getEmail(), passwordEncoder.encode(randomPass), role);
		user = userService.saveUser(user);
		
		customer.setUserId(user.getId());
		
		customer = customerRepository.save(customer);
		
		return customer;
	}
	
	/**
	 * Gets customer by id from database.
	 * @param id
	 * @return
	 */
	public Customer getCustomerById(Long id) {
		Optional<Customer> customerOptional = customerRepository.findById(id);
		Customer customer = customerOptional.get();
		return customer;
	}
	
	
	
	
	/**
	 * Password builder
	 * 
	 * @param len
	 * @return
	 */
	private static String alphaNumericString(int len) {
		String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();

		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++) {
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		}
		return sb.toString();
	}

	public Customer getCustomerByIdUser(Long id) {
		Customer customer = customerRepository.getByUserid(id);
		return customer;
	}

	
	
	
}
