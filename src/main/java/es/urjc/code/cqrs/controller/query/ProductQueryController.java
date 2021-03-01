package es.urjc.code.cqrs.controller.query;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.cqrs.controller.dto.ProductResponseDTO;
import es.urjc.code.cqrs.domain.service.query.ProductQueryService;

@RestController
@RequestMapping("/api/products")
public class ProductQueryController {

	private ProductQueryService productService;
	private ModelMapper mapper = new ModelMapper();

	public ProductQueryController(ProductQueryService productService) {
		this.productService = productService;
	}
	
	@GetMapping
	public Collection<ProductResponseDTO> getProducts() {
		return Arrays.asList(mapper.map(productService.getProducts(), ProductResponseDTO[].class));
	}

	@GetMapping("/{id}")
	public ProductResponseDTO getProduct(@PathVariable UUID id) {
		return mapper.map(productService.getProduct(id), ProductResponseDTO.class);
	}
}
