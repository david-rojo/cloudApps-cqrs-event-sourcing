package es.urjc.code.cqrs.domain;

import java.util.Collection;

import org.modelmapper.ModelMapper;

public class CartExpenditureServiceImpl implements CartExpenditureService {

	private CartExpenditureRepository repository;
	
	ModelMapper mapper = new ModelMapper();
	
	public CartExpenditureServiceImpl(CartExpenditureRepository repository) {
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
