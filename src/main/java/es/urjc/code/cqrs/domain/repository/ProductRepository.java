package es.urjc.code.cqrs.domain.repository;

import java.util.Collection;
import java.util.UUID;

import es.urjc.code.cqrs.domain.dto.FullProductDTO;

public interface ProductRepository {
	
	Collection<FullProductDTO> finAll();

	FullProductDTO findById(UUID id);

	FullProductDTO save(FullProductDTO product);

	void deleteById(UUID id);
}
