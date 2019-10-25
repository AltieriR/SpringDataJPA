package dev.altieri.springdatajpa.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.altieri.springdatajpa.orders.model.Person;

public interface CustomerRepository extends JpaRepository<Person, Long> {
	
	List<Person> findCustomerByName(String name);
	
}
