package es.urjc.code.cqrs.service.event.model;

import java.util.UUID;

public class DeletedCartEvent {

	private UUID id;

	public DeletedCartEvent() {
		super();
	}

	public DeletedCartEvent(UUID id) {
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
