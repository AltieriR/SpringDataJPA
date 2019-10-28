package dev.altieri.springdatajpa.orders.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.PersistenceException;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.Setter;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
@Getter
@Setter
public abstract class Person extends AbstractBean {
	
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
