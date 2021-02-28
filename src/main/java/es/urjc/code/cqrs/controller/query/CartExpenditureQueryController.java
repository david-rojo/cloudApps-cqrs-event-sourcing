package es.urjc.code.cqrs.controller.query;

import java.util.Arrays;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.cqrs.controller.dto.CartExpenditureResponseDTO;
import es.urjc.code.cqrs.domain.service.query.CartExpenditureQueryService;

@RestController
@RequestMapping("/api/cartexpenditure")
public class CartExpenditureQueryController {

	private CartExpenditureQueryService cartExpenditureService;
	private ModelMapper mapper = new ModelMapper();
	
	public CartExpenditureQueryController(CartExpenditureQueryService cartExpenditureService) {
		this.cartExpenditureService = cartExpenditureService;
	}
	
	@GetMapping
	public Collection<CartExpenditureResponseDTO> getCartExpenditures() {
		return Arrays.asList(mapper.map(cartExpenditureService.getCartExpenditures(), CartExpenditureResponseDTO[].class));
	}

}
