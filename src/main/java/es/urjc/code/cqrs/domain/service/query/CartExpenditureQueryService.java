package es.urjc.code.cqrs.domain.service.query;

import java.util.Collection;

import es.urjc.code.cqrs.domain.dto.FullCartExpenditureDTO;

public interface CartExpenditureQueryService {
	
	public Collection<FullCartExpenditureDTO> getCartExpenditures();
	
	public FullCartExpenditureDTO createCartExpenditure(FullCartExpenditureDTO fullCartExpenditureDTO);

}
