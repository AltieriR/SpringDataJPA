package dev.altieri.springdatajpa.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.altieri.springdatajpa.orders.model.LegalPerson;

public interface LegalPersonRepository extends JpaRepository<LegalPerson, Long> {
	
	List<LegalPerson> findCustomerByName(String name);
	
}
