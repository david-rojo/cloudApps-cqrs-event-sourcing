package es.urjc.code.cqrs.service;

import java.util.List;
import java.util.Random;

import es.urjc.code.cqrs.domain.ShoppingCartItem;
import es.urjc.code.cqrs.domain.service.query.ValidationQueryService;

public class ValidationQueryServiceImpl implements ValidationQueryService {

	@Override
	public boolean validate(List<ShoppingCartItem> items) {
		Random rnd = new Random();

		return rnd.nextBoolean();
	}


}
