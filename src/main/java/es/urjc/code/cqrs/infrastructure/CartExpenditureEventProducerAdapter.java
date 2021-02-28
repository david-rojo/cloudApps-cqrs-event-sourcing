package es.urjc.code.cqrs.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

import es.urjc.code.cqrs.domain.CartExpenditureEventProducer;
import es.urjc.code.cqrs.domain.dto.FullCartExpenditureDTO;

@Component
public class CartExpenditureEventProducerAdapter implements CartExpenditureEventProducer {

	private Logger log = LoggerFactory.getLogger(CartExpenditureEventProducerAdapter.class);
	private final ApplicationEventPublisher producer;
	
	public CartExpenditureEventProducerAdapter(ApplicationEventPublisher producer) {
		this.producer = producer;
	}
	
	@Override
	public void publish(FullCartExpenditureDTO fullCartExpenditureDTO) {
		producer.publishEvent(fullCartExpenditureDTO);
		log.info("CartExpenditureEvent produced for id {}", fullCartExpenditureDTO.getId());
		
	}

}
