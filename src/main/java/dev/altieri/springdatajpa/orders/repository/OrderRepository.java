package dev.altieri.springdatajpa.orders.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.altieri.springdatajpa.orders.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}
