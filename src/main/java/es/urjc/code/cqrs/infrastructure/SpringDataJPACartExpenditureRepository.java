package es.urjc.code.cqrs.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SpringDataJPACartExpenditureRepository extends JpaRepository<CartExpenditureEntity, Long> {

}
