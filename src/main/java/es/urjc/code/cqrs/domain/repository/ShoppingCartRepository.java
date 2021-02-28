package es.urjc.code.cqrs.domain.repository;

import es.urjc.code.cqrs.domain.dto.FullShoppingCartDTO;

public interface ShoppingCartRepository {
	FullShoppingCartDTO findById(Long id);

	FullShoppingCartDTO save(FullShoppingCartDTO shoppingCart);

	void deleteById(Long id);
}
