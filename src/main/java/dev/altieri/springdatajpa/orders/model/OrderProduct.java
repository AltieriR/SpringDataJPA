package dev.altieri.springdatajpa.orders.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.PersistenceException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class OrderProduct extends AbstractBean {

	@ManyToOne(optional=false)
	private Product product;
	
	@ManyToOne(optional=false)
	private Order order;
	
	private int quantity;

	public Product getProduct() {
		if(product==null) throw new PersistenceException("Product not found");
		return product;
	}

	public Order getOrder() {
		if(order==null) throw new PersistenceException("Order not found");
		return order;
	}

	public void setProduct(Product product) {
		if(order==null) throw new PersistenceException("Product must be provided");
		this.product = product;
	}

	public void setOrder(Order order) {
		if(order==null) throw new PersistenceException("Order must be provided");
		this.order = order;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
