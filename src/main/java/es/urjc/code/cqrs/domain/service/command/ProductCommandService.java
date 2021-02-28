package es.urjc.code.cqrs.domain.service.command;

import es.urjc.code.cqrs.domain.dto.FullProductDTO;
import es.urjc.code.cqrs.domain.dto.ProductDTO;

public interface ProductCommandService {

	public FullProductDTO createProduct(ProductDTO productDTO);
	
	public FullProductDTO deleteProduct(Long id);

}
