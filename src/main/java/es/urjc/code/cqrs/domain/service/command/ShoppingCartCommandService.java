package es.urjc.code.cqrs.domain.service.command;

import java.util.UUID;

import es.urjc.code.cqrs.domain.dto.FullProductDTO;
import es.urjc.code.cqrs.domain.dto.FullShoppingCartDTO;
import es.urjc.code.cqrs.domain.dto.ShoppingCartDTO;

public interface ShoppingCartCommandService {

	public FullShoppingCartDTO createShoppingCart();

	public FullShoppingCartDTO updateShoppingCart(UUID id, ShoppingCartDTO shoppingCartDTO);

	public FullShoppingCartDTO deleteShoppingCart(UUID id);

	public FullShoppingCartDTO addProduct(UUID idShoppingCart, UUID idProduct, int nProducts);

	public FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
	        int quantity);

	public FullShoppingCartDTO deleteProduct(UUID idShoppingCart, UUID idProduct);
}
