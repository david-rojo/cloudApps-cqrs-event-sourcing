package es.urjc.code.cqrs.infrastructure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import es.urjc.code.cqrs.domain.dto.FullCartExpenditureDTO;
import es.urjc.code.cqrs.domain.repository.CartExpenditureRepository;

@Component
public class CartExpenditureEventConsumer {

	private Logger log = LoggerFactory.getLogger(CartExpenditureEventConsumer.class);
	
	private final CartExpenditureRepository cartExpenditureRepository;

	public CartExpenditureEventConsumer(CartExpenditureRepository cartExpenditureRepository) {
		this.cartExpenditureRepository = cartExpenditureRepository;
	}

	@EventListener
	public void saveExpenditure(FullCartExpenditureDTO fullCartExpenditureDTO) {		
		log.info("CartExpenditureEvent consumed for id {}", fullCartExpenditureDTO.getId());
		this.cartExpenditureRepository.save(fullCartExpenditureDTO);
	}

}
