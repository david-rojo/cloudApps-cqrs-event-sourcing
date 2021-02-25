package es.urjc.code.cqrs.domain;

import java.util.List;

public interface ValidationService {

	boolean validate(List<ShoppingCartItem> items);
	
}
