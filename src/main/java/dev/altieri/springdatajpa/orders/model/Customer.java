package dev.altieri.springdatajpa.orders.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PersistenceException;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Customer extends AbstractBean {
	
	@Column(nullable = false)
	private String name;
	
	@Temporal(TemporalType.DATE)
	private Date birth;

	public String getName() {
		if(name==null) throw new PersistenceException("Customer must have a name");
		return name;
	}
	
	public void setName(String name) {
		if(name==null) throw new PersistenceException("Customer must have a name");
		this.name = name;
	}

}
