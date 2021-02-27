package es.urjc.code.cqrs.domain;

import java.util.Collection;

public interface CartExpenditureRepository {

	Collection<FullCartExpenditureDTO> findAll();
	
}
