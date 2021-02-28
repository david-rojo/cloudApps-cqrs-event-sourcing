package es.urjc.code.cqrs.domain;

public interface CartExpenditureEventProducer {

	public void publish(FullCartExpenditureDTO fullCartExpenditureDTO);

}
