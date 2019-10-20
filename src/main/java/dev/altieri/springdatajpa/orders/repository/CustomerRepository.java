package dev.altieri.springdatajpa.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.altieri.springdatajpa.orders.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {
	
	List<Customer> findCustomerByName(String name);
	
}
