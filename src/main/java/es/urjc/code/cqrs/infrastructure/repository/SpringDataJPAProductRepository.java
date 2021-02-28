package es.urjc.code.cqrs.infrastructure.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.urjc.code.cqrs.infrastructure.entity.ProductEntity;

public interface SpringDataJPAProductRepository extends JpaRepository<ProductEntity, Long> {

}
