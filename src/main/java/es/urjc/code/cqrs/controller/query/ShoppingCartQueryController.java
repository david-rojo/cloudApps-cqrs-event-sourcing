package es.urjc.code.cqrs.controller.query;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.cqrs.controller.dto.ShoppingCartResponseDTO;
import es.urjc.code.cqrs.domain.service.query.ShoppingCartQueryService;

@RestController
@RequestMapping("/api/shoppingcarts")
public class ShoppingCartQueryController {

	private ShoppingCartQueryService shoppingService;
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartQueryController(ShoppingCartQueryService shoppingService) {
		this.shoppingService = shoppingService;
	}

	@GetMapping("/{id}")
	public ShoppingCartResponseDTO getShoppingCart(@PathVariable Long id) {
		return mapper.map(shoppingService.getShoppingCart(id), ShoppingCartResponseDTO.class);
	}
	
}
