package es.urjc.code.cqrs.domain.service.query;

import java.util.Collection;

import es.urjc.code.cqrs.domain.dto.FullProductDTO;

public interface ProductQueryService {
	
	public Collection<FullProductDTO> getProducts();
	public FullProductDTO getProduct(Long id);
}
