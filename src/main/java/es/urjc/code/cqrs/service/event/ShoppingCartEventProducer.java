package es.urjc.code.cqrs.service.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import es.urjc.code.cqrs.service.event.model.DeletedCartEvent;
import es.urjc.code.cqrs.service.event.model.SavedCartEvent;

@Service
public class ShoppingCartEventProducer {

	private Logger log = LoggerFactory.getLogger(ShoppingCartEventProducer.class);
	
	private final ApplicationEventPublisher producer;
	
	public ShoppingCartEventProducer(ApplicationEventPublisher producer) {
		this.producer = producer;
	}
	
	public void send(SavedCartEvent event) {
		producer.publishEvent(event);
		log.info("SavedCartEvent produced for id {}", event.getId());	
	}
	
	public void send(DeletedCartEvent event) {
		producer.publishEvent(event);
		log.info("DeletedCartEvent produced for id {}", event.getId());	
	}

}
