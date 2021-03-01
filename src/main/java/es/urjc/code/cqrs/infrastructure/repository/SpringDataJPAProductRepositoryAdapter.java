package es.urjc.code.cqrs.infrastructure.repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import es.urjc.code.cqrs.domain.dto.FullProductDTO;
import es.urjc.code.cqrs.domain.repository.ProductRepository;
import es.urjc.code.cqrs.infrastructure.entity.ProductEntity;
import es.urjc.code.cqrs.infrastructure.exception.ProductNotFoundException;

@Component
public class SpringDataJPAProductRepositoryAdapter implements ProductRepository {

	private SpringDataJPAProductRepository repository;
	private ModelMapper mapper = new ModelMapper();

	public SpringDataJPAProductRepositoryAdapter(SpringDataJPAProductRepository repository) {
		this.repository = repository;
	}

	@Override
	public Collection<FullProductDTO> finAll() {
		return Arrays.asList(mapper.map(repository.findAll(), FullProductDTO[].class));
	}

	@Override
	public FullProductDTO findById(UUID id) {
		return mapper.map(repository.findById(id).orElseThrow(ProductNotFoundException::new), FullProductDTO.class);
	}

	@Override
	public FullProductDTO save(FullProductDTO product) {
		ProductEntity productEntity = mapper.map(product, ProductEntity.class);
		repository.save(productEntity);

		return mapper.map(productEntity, FullProductDTO.class);
	}

	@Override
	public void deleteById(UUID id) {
		repository.deleteById(id);
	}

}
