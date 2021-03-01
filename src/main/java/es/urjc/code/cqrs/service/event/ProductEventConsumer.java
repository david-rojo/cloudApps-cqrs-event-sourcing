package es.urjc.code.cqrs.service.event;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import es.urjc.code.cqrs.domain.dto.FullProductDTO;
import es.urjc.code.cqrs.domain.repository.ProductRepository;
import es.urjc.code.cqrs.service.event.model.CreatedProductEvent;
import es.urjc.code.cqrs.service.event.model.DeletedProductEvent;

@Service
public class ProductEventConsumer {

	private Logger log = LoggerFactory.getLogger(ProductEventConsumer.class);
	
	private final ProductRepository repository;
	
    private ModelMapper mapper = new ModelMapper();

	public ProductEventConsumer(ProductRepository repository) {
		this.repository = repository;
	}

	@EventListener
	public void receive(CreatedProductEvent event) {		
		log.info("CreatedProductEvent consumed for id {}", event.getId());
		this.repository.save(mapper.map(event, FullProductDTO.class));
	}
	
	@EventListener
	public void receive(DeletedProductEvent event) {		
		log.info("DeletedProductEvent consumed for id {}", event.getId());
		this.repository.deleteById(event.getId());
	}
}
