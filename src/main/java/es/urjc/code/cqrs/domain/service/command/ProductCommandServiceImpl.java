package es.urjc.code.cqrs.domain.service.command;

import java.util.UUID;

import org.modelmapper.ModelMapper;

import es.urjc.code.cqrs.domain.dto.FullProductDTO;
import es.urjc.code.cqrs.domain.dto.ProductDTO;
import es.urjc.code.cqrs.domain.repository.ProductRepository;
import es.urjc.code.cqrs.service.event.ProductEventProducer;
import es.urjc.code.cqrs.service.event.model.CreatedProductEvent;
import es.urjc.code.cqrs.service.event.model.DeletedProductEvent;

public class ProductCommandServiceImpl implements ProductCommandService {

	private ProductRepository repository;
	
	private ModelMapper mapper = new ModelMapper();
	
	private ProductEventProducer eventProducer;
	
	public ProductCommandServiceImpl(ProductRepository repository, ProductEventProducer eventProducer) {
		this.repository = repository;
		this.eventProducer = eventProducer;
	}	
	
	@Override
	public FullProductDTO createProduct(ProductDTO productDTO) {
		productDTO.setId(UUID.randomUUID());
		eventProducer.send(mapper.map(productDTO, CreatedProductEvent.class));
		return mapper.map(productDTO, FullProductDTO.class);
	}

	@Override
	public FullProductDTO deleteProduct(UUID id) {
		FullProductDTO product = repository.findById(id);
		eventProducer.send(mapper.map(product, DeletedProductEvent.class));
		return product;
	}
}
