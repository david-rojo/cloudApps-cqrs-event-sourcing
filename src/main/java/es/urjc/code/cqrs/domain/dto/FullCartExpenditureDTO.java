package es.urjc.code.cqrs.domain.dto;

import java.util.UUID;

public class FullCartExpenditureDTO {

	private UUID id;
	private double expenditure;
	
	public FullCartExpenditureDTO() {
		super();
	}

	public FullCartExpenditureDTO(UUID id, double expenditure) {
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
