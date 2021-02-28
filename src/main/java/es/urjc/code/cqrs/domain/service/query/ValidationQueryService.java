package es.urjc.code.cqrs.domain.service.query;

import java.util.List;

import es.urjc.code.cqrs.domain.ShoppingCartItem;

public interface ValidationQueryService {

	boolean validate(List<ShoppingCartItem> items);
	
}
