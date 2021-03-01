package es.urjc.code.cqrs.service.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import es.urjc.code.cqrs.service.event.model.CompletedCartEvent;

@Service
public class CartExpenditureEventProducer {

	private Logger log = LoggerFactory.getLogger(CartExpenditureEventProducer.class);
	
	private final ApplicationEventPublisher producer;
	
	public CartExpenditureEventProducer(ApplicationEventPublisher producer) {
		this.producer = producer;
	}
	
	public void send(CompletedCartEvent event) {
		producer.publishEvent(event);
		log.info("CompletedCartEvent produced for id {}", event.getId());
		
	}

}
