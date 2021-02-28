package es.urjc.code.cqrs.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.code.cqrs.infrastructure.entity.ShoppingCartEntity;

public interface SpringDataJPAShoppingCartRepository extends JpaRepository<ShoppingCartEntity, Long> {

}
