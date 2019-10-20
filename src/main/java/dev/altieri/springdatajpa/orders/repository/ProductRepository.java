package dev.altieri.springdatajpa.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.altieri.springdatajpa.orders.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
