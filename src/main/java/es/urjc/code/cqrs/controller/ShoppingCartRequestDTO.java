package es.urjc.code.cqrs.controller;

import es.urjc.code.cqrs.domain.ShoppingCartStatus;

public class ShoppingCartRequestDTO {
	
	private ShoppingCartStatus status;

	public ShoppingCartRequestDTO() {
		super();
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}

}
