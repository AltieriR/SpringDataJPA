package dev.altieri.springdatajpa.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.altieri.springdatajpa.orders.model.OrderProduct;

public interface OrderProductRepository extends JpaRepository<OrderProduct, Long> {

}
