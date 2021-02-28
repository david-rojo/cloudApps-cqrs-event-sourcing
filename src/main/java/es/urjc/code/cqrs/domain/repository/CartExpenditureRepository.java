package es.urjc.code.cqrs.domain.repository;

import java.util.Collection;

import es.urjc.code.cqrs.domain.dto.FullCartExpenditureDTO;

public interface CartExpenditureRepository {

	Collection<FullCartExpenditureDTO> findAll();
	
	FullCartExpenditureDTO save(FullCartExpenditureDTO fullCartExpenditureDTO);
	
}
