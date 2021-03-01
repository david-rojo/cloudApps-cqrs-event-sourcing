package es.urjc.code.cqrs.service.event;

import org.modelmapper.ModelMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;

import es.urjc.code.cqrs.domain.dto.FullCartExpenditureDTO;
import es.urjc.code.cqrs.domain.repository.CartExpenditureRepository;
import es.urjc.code.cqrs.service.event.model.CompletedCartEvent;

@Service
public class CartExpenditureEventConsumer {

	private Logger log = LoggerFactory.getLogger(CartExpenditureEventConsumer.class);
	
	private final CartExpenditureRepository repository;
	
    private ModelMapper mapper = new ModelMapper();

	public CartExpenditureEventConsumer(CartExpenditureRepository repository) {
		this.repository = repository;
	}

	@EventListener
	public void receive(CompletedCartEvent event) {		
		log.info("CompletedCartEvent consumed for id {}", event.getId());
		this.repository.save(mapper.map(event, FullCartExpenditureDTO.class));
	}

}
