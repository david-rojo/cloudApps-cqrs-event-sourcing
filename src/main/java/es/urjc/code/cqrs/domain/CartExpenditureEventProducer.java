package es.urjc.code.cqrs.domain;

import es.urjc.code.cqrs.domain.dto.FullCartExpenditureDTO;

public interface CartExpenditureEventProducer {

	public void publish(FullCartExpenditureDTO fullCartExpenditureDTO);

}
