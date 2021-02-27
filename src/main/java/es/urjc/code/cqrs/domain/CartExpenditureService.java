package es.urjc.code.cqrs.domain;

import java.util.Collection;

public interface CartExpenditureService {
	
	public Collection<FullCartExpenditureDTO> getCartExpenditures();

}
