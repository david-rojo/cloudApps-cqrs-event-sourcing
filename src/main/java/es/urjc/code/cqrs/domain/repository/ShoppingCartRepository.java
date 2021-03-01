package es.urjc.code.cqrs.domain.repository;

import java.util.UUID;

import es.urjc.code.cqrs.domain.dto.FullShoppingCartDTO;

public interface ShoppingCartRepository {
	
	FullShoppingCartDTO findById(UUID id);

	FullShoppingCartDTO save(FullShoppingCartDTO shoppingCart);

	void deleteById(UUID id);
}
