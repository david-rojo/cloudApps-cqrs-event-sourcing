package es.urjc.code.cqrs.domain;

import java.util.Collection;

public interface ProductRepository {
	Collection<FullProductDTO> finAll();

	FullProductDTO findById(Long id);

	FullProductDTO save(FullProductDTO product);

	void deleteById(Long id);
}
