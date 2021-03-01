package es.urjc.code.cqrs.service.event.model;

import java.util.UUID;

public class CompletedCartEvent {

	private UUID id;
	private double expenditure;
	
	public CompletedCartEvent() {
		super();
	}

	public CompletedCartEvent(UUID id, double expenditure) {
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
