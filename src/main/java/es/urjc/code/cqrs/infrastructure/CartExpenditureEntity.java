package es.urjc.code.cqrs.infrastructure;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cart_expenditure")
public class CartExpenditureEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private double expenditure;

	public CartExpenditureEntity() {
		super();
	}

	public CartExpenditureEntity(Long id, double expenditure) {
		super();
		this.id = id;
		this.expenditure = expenditure;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public double getExpenditure() {
		return expenditure;
	}

	public void setExpenditure(double expenditure) {
		this.expenditure = expenditure;
	}
	
}
