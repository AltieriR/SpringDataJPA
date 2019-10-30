package dev.altieri.springdatajpa.orders.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.altieri.springdatajpa.orders.model.NaturalPerson;

public interface NaturalPersonRepository extends JpaRepository<NaturalPerson, Long> {
	
	List<NaturalPerson> findCustomerByName(String name);
	
}
