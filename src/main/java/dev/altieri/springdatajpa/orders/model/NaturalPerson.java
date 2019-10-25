package dev.altieri.springdatajpa.orders.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@DiscriminatorValue("Natural")
public class NaturalPerson {

	private String nationalIdentityNumber;
}
