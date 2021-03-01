package es.urjc.code.cqrs.service.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import es.urjc.code.cqrs.service.event.model.CreatedProductEvent;

@Service
public class ProductEventProducer {

	private Logger log = LoggerFactory.getLogger(ProductEventProducer.class);
	
	private final ApplicationEventPublisher producer;
	
	public ProductEventProducer(ApplicationEventPublisher producer) {
		this.producer = producer;
	}
	
	public void send(CreatedProductEvent event) {
		producer.publishEvent(event);
		log.info("CreatedProductEvent produced for id {}", event.getId());
		
	}

}
