package es.urjc.code.cqrs.controller.dto;

import java.util.UUID;

public class CartExpenditureResponseDTO {

	private UUID id;
	private double expenditure;
	
	public CartExpenditureResponseDTO() {
		super();
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
