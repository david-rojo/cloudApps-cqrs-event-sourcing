package es.urjc.code.cqrs.service.event.model;

import java.util.List;
import java.util.UUID;

import es.urjc.code.cqrs.domain.ShoppingCartStatus;
import es.urjc.code.cqrs.domain.dto.FullShoppingCartItemDTO;

public class SavedCartEvent {

	private UUID id;
	private ShoppingCartStatus status;
	private List<FullShoppingCartItemDTO> items;
	private double price;

	public SavedCartEvent() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ShoppingCartStatus getStatus() {
		return status;
	}

	public void setStatus(ShoppingCartStatus status) {
		this.status = status;
	}

	public List<FullShoppingCartItemDTO> getItems() {
		return items;
	}

	public void setItems(List<FullShoppingCartItemDTO> items) {
		this.items = items;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
