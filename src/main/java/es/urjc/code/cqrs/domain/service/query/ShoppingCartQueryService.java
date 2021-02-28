package es.urjc.code.cqrs.domain.service.query;

import es.urjc.code.cqrs.domain.dto.FullShoppingCartDTO;

public interface ShoppingCartQueryService {
	
	public FullShoppingCartDTO getShoppingCart(Long id);

}
