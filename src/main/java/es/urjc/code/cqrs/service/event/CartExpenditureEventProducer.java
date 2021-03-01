package es.urjc.code.cqrs.service.event;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import es.urjc.code.cqrs.domain.dto.FullCartExpenditureDTO;

@Component
public class CartExpenditureEventProducer {

	private Logger log = LoggerFactory.getLogger(CartExpenditureEventProducer.class);
	private final ApplicationEventPublisher producer;
	
	public CartExpenditureEventProducer(ApplicationEventPublisher producer) {
		this.producer = producer;
	}
	
	public void publish(FullCartExpenditureDTO fullCartExpenditureDTO) {
		producer.publishEvent(fullCartExpenditureDTO);
		log.info("CartExpenditureEvent produced for id {}", fullCartExpenditureDTO.getId());
		
	}

}
