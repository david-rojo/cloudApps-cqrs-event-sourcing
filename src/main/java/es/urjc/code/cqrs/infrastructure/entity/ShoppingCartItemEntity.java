package es.urjc.code.cqrs.infrastructure.entity;

import java.util.UUID;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="shopping_cart_item")
public class ShoppingCartItemEntity {

	@Id
	private UUID id;

	@OneToOne
	private ProductEntity product;

	private int quantity;

	public ShoppingCartItemEntity() {
		super();
	}

	public ShoppingCartItemEntity(UUID id, ProductEntity product, int quantity) {
		super();
		this.id = id;
		this.product = product;
		this.quantity = quantity;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public ProductEntity getProduct() {
		return product;
	}

	public void setProduct(ProductEntity product) {
		this.product = product;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getTotalPrice() {
		return this.quantity * this.product.getPrice();
	}

}
