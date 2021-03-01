package es.urjc.code.cqrs.controller.command;

import static org.springframework.web.servlet.support.ServletUriComponentsBuilder.fromCurrentRequest;

import java.net.URI;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.urjc.code.cqrs.controller.dto.ProductRequestDTO;
import es.urjc.code.cqrs.controller.dto.ProductResponseDTO;
import es.urjc.code.cqrs.domain.dto.FullProductDTO;
import es.urjc.code.cqrs.domain.dto.ProductDTO;
import es.urjc.code.cqrs.domain.service.command.ProductCommandService;

@RestController
@RequestMapping("/api/products")
public class ProductCommandController {

	private ProductCommandService productService;
	private ModelMapper mapper = new ModelMapper();

	public ProductCommandController(ProductCommandService productService) {
		this.productService = productService;
	}

	@PostMapping
	public ResponseEntity<ProductResponseDTO> createProduct(@RequestBody ProductRequestDTO productRequestDTO) {
		ProductDTO productDTO = mapper.map(productRequestDTO, ProductDTO.class);
		FullProductDTO fullProductDTO = productService.createProduct(productDTO);

		URI location = fromCurrentRequest().path("/{id}")
		        .buildAndExpand(fullProductDTO.getId()).toUri();

		return ResponseEntity.created(location).body(
		        mapper.map(fullProductDTO, ProductResponseDTO.class));
	}

	@DeleteMapping("/{id}")
	public ProductResponseDTO deleteProduct(@PathVariable UUID id) {
		return mapper.map(productService.deleteProduct(id), ProductResponseDTO.class);
	}

}
