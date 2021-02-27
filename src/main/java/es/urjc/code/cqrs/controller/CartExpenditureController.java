package es.urjc.code.cqrs.controller;

import java.util.Arrays;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.cqrs.domain.CartExpenditureService;

@RestController
@RequestMapping("/api/cartexpenditure")
public class CartExpenditureController {

	private CartExpenditureService cartExpenditureService;
	private ModelMapper mapper = new ModelMapper();
	
	public CartExpenditureController(CartExpenditureService cartExpenditureService) {
		this.cartExpenditureService = cartExpenditureService;
	}
	
	@GetMapping
	public Collection<CartExpenditureResponseDTO> getCartExpenditures() {
		return Arrays.asList(mapper.map(cartExpenditureService.getCartExpenditures(), CartExpenditureResponseDTO[].class));
	}

}
