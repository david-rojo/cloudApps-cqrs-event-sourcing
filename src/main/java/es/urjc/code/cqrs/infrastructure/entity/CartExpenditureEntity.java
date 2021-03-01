package es.urjc.code.cqrs.infrastructure.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart_expenditure")
public class CartExpenditureEntity {

	@Id
	private UUID id;
	
	private double expenditure;

	public CartExpenditureEntity() {
		super();
	}

	public CartExpenditureEntity(UUID id, double expenditure) {
		super();
		this.id = id;
		this.expenditure = expenditure;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public double getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(double expenditure) {
		this.expenditure = expenditure;
	}
	
}
