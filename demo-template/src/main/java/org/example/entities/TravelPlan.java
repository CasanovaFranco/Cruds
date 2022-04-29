package org.example.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "travelplans")
public class TravelPlan {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private Long id;
	private String name;

	@Column(name = "unit_price", nullable = false)
	private double unitPrice;

	@Column(name = "units_stock", nullable = false)
	private double untisStock;

	@ManyToOne
	@JoinColumn(name = "affiliate_id", nullable = false)
	private Affiliate affiliate;

	private String description;
	private Long time;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getUnitPrice() {
		return unitPrice;
	}

	public void setUnitPrice(double unitPrice) {
		this.unitPrice = unitPrice;
	}

	public double getUntisStock() {
		return untisStock;
	}

	public void setUntisStock(double untisStock) {
		this.untisStock = untisStock;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getTime() {
		return time;
	}

	public void setTime(Long time) {
		this.time = time;
	}

	public Affiliate getAffiliate() {
		return affiliate;
	}

	public void setAffiliate(Affiliate affiliate) {
		this.affiliate = affiliate;
	}

}
