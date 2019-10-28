package dev.altieri.springdatajpa.orders.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("legal")
@NoArgsConstructor
public class LegalPerson extends Person {

	private String legalEntityIdentifier;

	public String getLegalEntityIdentifier() {
		return legalEntityIdentifier;
	}

	public void setLegalEntityIdentifier(String legalEntityIdentifier) {
		this.legalEntityIdentifier = legalEntityIdentifier;
	}
	
}
