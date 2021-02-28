package es.urjc.code.cqrs.domain.service.query;

import java.util.Collection;

import org.modelmapper.ModelMapper;

import es.urjc.code.cqrs.domain.dto.FullCartExpenditureDTO;
import es.urjc.code.cqrs.domain.repository.CartExpenditureRepository;

public class CartExpenditureQueryServiceImpl implements CartExpenditureQueryService {

	private CartExpenditureRepository repository;
	
	ModelMapper mapper = new ModelMapper();
	
	public CartExpenditureQueryServiceImpl(CartExpenditureRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Collection<FullCartExpenditureDTO> getCartExpenditures() {
		return repository.findAll();
	}

	@Override
	public FullCartExpenditureDTO createCartExpenditure(FullCartExpenditureDTO fullCartExpenditureDTO) {
		return repository.save(fullCartExpenditureDTO);
	}

}
