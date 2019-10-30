package dev.altieri.springdatajpa.orders.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.PersistenceException;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "Purchase")
public class Order extends AbstractBean {
    @Temporal(TemporalType.TIMESTAMP)
	private Date time;

    @OneToOne(optional = false)
	private Person customer;

    
    @OneToOne(optional = true)
    private Person referral;

	@Column(nullable = false, length=30)
    @ElementCollection
    private List<String> paymentMethod;

    @ElementCollection @Column(length=5)
    private List<Integer> paymentTerm;

    @ElementCollection @Column(length=50)
    private List<Integer> coupon;
    
	public Person getCustomer() {
		if(customer==null) throw new PersistenceException("Product not found");
		return customer;
	}

	public void setCustomer(Person customer) {
		if(customer==null) throw new PersistenceException("Product must be provided");
		this.customer = customer;
	}

	public List<String> getPaymentMethod() {
		if(paymentMethod==null || paymentMethod.size() < 2) throw new PersistenceException("Payment Method not found");
		return paymentMethod;
	}

	public void setPaymentMethod(List<String> paymentMethod) {
		if(paymentMethod==null || paymentMethod.size() < 2) throw new PersistenceException("Payment must be provided");
		this.paymentMethod = paymentMethod;
	}

	public Date getTime() {
		return time;
	}

	public Person getReferral() {
		return referral;
	}

	public List<Integer> getPaymentTerm() {
		return paymentTerm;
	}

	public List<Integer> getCoupon() {
		return coupon;
	}

	public void setTime(Date time) {
		this.time = time;
	}

	public void setReferral(Person referral) {
		this.referral = referral;
	}

	public void setPaymentTerm(List<Integer> paymentTerm) {
		this.paymentTerm = paymentTerm;
	}

	public void setCoupon(List<Integer> coupon) {
		this.coupon = coupon;
	}
	
}
