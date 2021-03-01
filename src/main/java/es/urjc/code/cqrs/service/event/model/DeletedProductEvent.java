package es.urjc.code.cqrs.service.event.model;

import java.util.UUID;

public class DeletedProductEvent {

	private UUID id;

	public DeletedProductEvent() {
		super();
	}

	public DeletedProductEvent(UUID id) {
		super();
		this.id = id;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}
	
}
