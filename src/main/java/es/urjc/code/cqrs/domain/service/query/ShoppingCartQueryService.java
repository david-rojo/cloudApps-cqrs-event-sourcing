package es.urjc.code.cqrs.domain.service.query;

import java.util.UUID;

import es.urjc.code.cqrs.domain.dto.FullShoppingCartDTO;

public interface ShoppingCartQueryService {
	
	public FullShoppingCartDTO getShoppingCart(UUID id);

}
