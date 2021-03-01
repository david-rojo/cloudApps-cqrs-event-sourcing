package es.urjc.code.cqrs.service.event;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import es.urjc.code.cqrs.domain.dto.FullShoppingCartDTO;
import es.urjc.code.cqrs.domain.repository.ShoppingCartRepository;
import es.urjc.code.cqrs.service.event.model.DeletedCartEvent;
import es.urjc.code.cqrs.service.event.model.SavedCartEvent;

@Service
public class ShoppingCartEventConsumer {

	private Logger log = LoggerFactory.getLogger(ShoppingCartEventConsumer.class);
	
	private final ShoppingCartRepository repository;
	
    private ModelMapper mapper = new ModelMapper();

	public ShoppingCartEventConsumer(ShoppingCartRepository repository) {
		this.repository = repository;
	}

	@EventListener
	public void receive(SavedCartEvent event) {		
		log.info("SavedCartEvent consumed for id {}", event.getId());
		this.repository.save(mapper.map(event, FullShoppingCartDTO.class));
	}
	
	@EventListener
	public void receive(DeletedCartEvent event) {		
		log.info("DeletedCartEvent consumed for id {}", event.getId());
		this.repository.deleteById(event.getId());
	}

}
