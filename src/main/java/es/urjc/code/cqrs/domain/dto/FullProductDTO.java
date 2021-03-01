package es.urjc.code.cqrs.domain.dto;

import java.util.UUID;

public class FullProductDTO {

	private UUID id;
	private String name;
	private String description;
	private double price;

	public FullProductDTO() {
		super();
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID uuid) {
		this.id = uuid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
