package es.urjc.code.cqrs.domain.service.query;

import org.modelmapper.ModelMapper;

import es.urjc.code.cqrs.domain.dto.FullShoppingCartDTO;
import es.urjc.code.cqrs.domain.repository.ShoppingCartRepository;

public class ShoppingCartQueryServiceImpl implements ShoppingCartQueryService {

	private ShoppingCartRepository shoppingCartRepository;
	
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartQueryServiceImpl(ShoppingCartRepository shoppingCartRepository) {
		this.shoppingCartRepository = shoppingCartRepository;
	}

	@Override
	public FullShoppingCartDTO getShoppingCart(Long id) {
		return mapper.map(shoppingCartRepository.findById(id), FullShoppingCartDTO.class);
	}

}
