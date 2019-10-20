package dev.altieri.springdatajpa.orders.endpoint;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.altieri.springdatajpa.orders.model.Customer;
import dev.altieri.springdatajpa.orders.repository.CustomerRepository;

@RestController
@RequestMapping("customer")
public class CustomerController {
	
	private CustomerRepository customerDao;

	@Autowired	
	public CustomerController(CustomerRepository customerDao) {
		this.customerDao = customerDao;
	}

	@GetMapping
	public List<Customer> getAllUsers() {
		return customerDao.findAll();
	}

	@GetMapping(path="/{name}")
	public List<Customer> getCustomersByName(@PathVariable("name") String n) {
		return customerDao.findCustomerByName(n);
	}
}
