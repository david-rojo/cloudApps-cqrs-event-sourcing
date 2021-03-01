package es.urjc.code.cqrs.domain.service.query;

import java.util.Collection;
import java.util.UUID;

import org.modelmapper.ModelMapper;

import es.urjc.code.cqrs.domain.dto.FullProductDTO;
import es.urjc.code.cqrs.domain.repository.ProductRepository;

public class ProductQueryServiceImpl implements ProductQueryService {

	private ProductRepository repository;
	ModelMapper mapper = new ModelMapper();
	
	public ProductQueryServiceImpl(ProductRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Collection<FullProductDTO> getProducts() {
		return repository.finAll();
	}

	@Override
	public FullProductDTO getProduct(UUID id) {
		return repository.findById(id);
	}

}
