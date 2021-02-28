package es.urjc.code.cqrs.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.code.cqrs.infrastructure.entity.CartExpenditureEntity;

public interface SpringDataJPACartExpenditureRepository extends JpaRepository<CartExpenditureEntity, Long> {

}
