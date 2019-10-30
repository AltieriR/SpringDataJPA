package dev.altieri.springdatajpa.orders;

import java.util.Arrays;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import dev.altieri.springdatajpa.orders.model.LegalPerson;
import dev.altieri.springdatajpa.orders.model.NaturalPerson;
import dev.altieri.springdatajpa.orders.model.Order;
import dev.altieri.springdatajpa.orders.model.OrderProduct;
import dev.altieri.springdatajpa.orders.model.Product;
import dev.altieri.springdatajpa.orders.repository.CustomerRepository;
import dev.altieri.springdatajpa.orders.repository.OrderProductRepository;
import dev.altieri.springdatajpa.orders.repository.OrderRepository;
import dev.altieri.springdatajpa.orders.repository.ProductRepository;

@SpringBootApplication
@Component
public class OrdersApplication {
	public static void main(String[] args) {
		SpringApplication.run(OrdersApplication.class, args);
        /*ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        OrdersApplication app = context.getBean(OrdersApplication.class);       
        app.testsJPA();*/
	}

}