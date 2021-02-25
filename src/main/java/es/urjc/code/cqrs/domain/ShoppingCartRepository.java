package es.urjc.code.cqrs.domain;

public interface ShoppingCartRepository {
	FullShoppingCartDTO findById(Long id);

	FullShoppingCartDTO save(FullShoppingCartDTO shoppingCart);

	void deleteById(Long id);
}
