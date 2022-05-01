package org.example.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "cards")
public class Card {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String number;
	private String cvv;
	private String owner;
	private String expiration;

	@ManyToOne
	@JoinColumn(name = "travelplan_id", nullable = false)
	private TravelPlan travelplan;
	
	@ManyToOne
	@JoinColumn(name = "method_id", nullable = false)
	private Method method;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getNumber() {
		return number;
	}


	public void setNumber(String number) {
		this.number = number;
	}


	public String getCvv() {
		return cvv;
	}


	public void setCvv(String cvv) {
		this.cvv = cvv;
	}


	public String getOwner() {
		return owner;
	}


	public void setOwner(String owner) {
		this.owner = owner;
	}


	public String getExpiration() {
		return expiration;
	}


	public void setExpiration(String expiration) {
		this.expiration = expiration;
	}


	public TravelPlan getTravelplan() {
		return travelplan;
	}


	public void setTravelplan(TravelPlan travelplan) {
		this.travelplan = travelplan;
	}


	public Method getMethod() {
		return method;
	}


	public void setMethod(Method method) {
		this.method = method;
	}
	
	
}
	