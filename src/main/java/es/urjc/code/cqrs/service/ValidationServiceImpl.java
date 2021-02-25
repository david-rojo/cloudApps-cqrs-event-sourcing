package es.urjc.code.cqrs.service;

import java.util.List;
import java.util.Random;

import es.urjc.code.cqrs.domain.ShoppingCartItem;
import es.urjc.code.cqrs.domain.ValidationService;

public class ValidationServiceImpl implements ValidationService {

	@Override
	public boolean validate(List<ShoppingCartItem> items) {
		Random rnd = new Random();

		return rnd.nextBoolean();
	}


}
