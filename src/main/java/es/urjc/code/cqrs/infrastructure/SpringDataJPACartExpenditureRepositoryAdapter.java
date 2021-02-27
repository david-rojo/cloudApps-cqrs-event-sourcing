package es.urjc.code.cqrs.infrastructure;

import java.util.Arrays;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import es.urjc.code.cqrs.domain.CartExpenditureRepository;
import es.urjc.code.cqrs.domain.FullCartExpenditureDTO;

@Component
public class SpringDataJPACartExpenditureRepositoryAdapter implements CartExpenditureRepository {

	private SpringDataJPACartExpenditureRepository repository;
	
	private ModelMapper mapper = new ModelMapper();

	public SpringDataJPACartExpenditureRepositoryAdapter(SpringDataJPACartExpenditureRepository repository) {
		this.repository = repository;
	}
	
	@Override
	public Collection<FullCartExpenditureDTO> findAll() {
		return Arrays.asList(mapper.map(repository.findAll(), FullCartExpenditureDTO[].class));
	}

}
