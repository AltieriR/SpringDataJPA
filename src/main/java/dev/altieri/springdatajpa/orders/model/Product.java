package dev.altieri.springdatajpa.orders.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Product extends AbstractBean {
	
	@Column(nullable = false)
	private String name;
	
	private Long quantity = 0l;
	private Long price;

	public String getName() {
		if(name==null) throw new PersistenceException("Product must have a name");
		return name;
	}
	
	public void setName(String name) {
		if(name==null) throw new PersistenceException("Product must have a name");
		this.name = name;
	}

}
