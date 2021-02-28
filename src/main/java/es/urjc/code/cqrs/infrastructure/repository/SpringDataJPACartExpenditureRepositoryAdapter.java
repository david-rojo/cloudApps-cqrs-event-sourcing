package es.urjc.code.cqrs.infrastructure.repository;

import java.util.Arrays;
import java.util.Collection;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import es.urjc.code.cqrs.domain.dto.FullCartExpenditureDTO;
import es.urjc.code.cqrs.domain.repository.CartExpenditureRepository;
import es.urjc.code.cqrs.infrastructure.entity.CartExpenditureEntity;

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

	@Override
	public FullCartExpenditureDTO save(FullCartExpenditureDTO fullCartExpenditureDTO) {
		 CartExpenditureEntity cartExpenditureEntity = mapper.map(fullCartExpenditureDTO, CartExpenditureEntity.class);
		 return mapper.map(this.repository.save(cartExpenditureEntity), FullCartExpenditureDTO.class);
	}

}
