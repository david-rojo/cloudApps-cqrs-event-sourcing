package es.urjc.code.cqrs.domain;

import java.util.Collection;

public interface CartExpenditureService {
	
	public Collection<FullCartExpenditureDTO> getCartExpenditures();
	
	public FullCartExpenditureDTO createCartExpenditure(FullCartExpenditureDTO fullCartExpenditureDTO);

}
