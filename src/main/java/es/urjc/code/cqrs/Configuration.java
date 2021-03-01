package es.urjc.code.cqrs;

import org.springframework.context.annotation.Bean;

import es.urjc.code.cqrs.domain.service.command.ProductCommandService;
import es.urjc.code.cqrs.domain.service.command.ProductCommandServiceImpl;
import es.urjc.code.cqrs.domain.service.command.ShoppingCartCommandService;
import es.urjc.code.cqrs.domain.service.command.ShoppingCartCommandServiceImpl;
import es.urjc.code.cqrs.domain.service.query.CartExpenditureQueryService;
import es.urjc.code.cqrs.domain.service.query.CartExpenditureQueryServiceImpl;
import es.urjc.code.cqrs.domain.service.query.ProductQueryService;
import es.urjc.code.cqrs.domain.service.query.ProductQueryServiceImpl;
import es.urjc.code.cqrs.domain.service.query.ShoppingCartQueryService;
import es.urjc.code.cqrs.domain.service.query.ShoppingCartQueryServiceImpl;
import es.urjc.code.cqrs.infrastructure.repository.SpringDataJPACartExpenditureRepositoryAdapter;
import es.urjc.code.cqrs.infrastructure.repository.SpringDataJPAProductRepositoryAdapter;
import es.urjc.code.cqrs.infrastructure.repository.SpringDataJPAShoppingCartRepositoryAdapter;
import es.urjc.code.cqrs.service.ValidationQueryServiceImpl;
import es.urjc.code.cqrs.service.event.CartExpenditureEventProducer;
import es.urjc.code.cqrs.service.event.ProductEventProducer;
import es.urjc.code.cqrs.service.event.ShoppingCartEventProducer;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ProductQueryService productQueryService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
		return new ProductQueryServiceImpl(repositoryAdapter);
	}
	
	@Bean
	public ProductCommandService productCommandService(SpringDataJPAProductRepositoryAdapter repositoryAdapter,
			ProductEventProducer productEventProducer) {
		return new ProductCommandServiceImpl(repositoryAdapter, productEventProducer);
	}
	
	@Bean
	public ShoppingCartQueryService shoppingCartQueryService(
	        SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter) {
		return new ShoppingCartQueryServiceImpl(shoppingCartRepositoryAdapter);
	}
	
	@Bean
	public ShoppingCartCommandService shoppingCartCommandService(
	        SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
	        SpringDataJPAProductRepositoryAdapter productRepositoryAdapter,
	        CartExpenditureEventProducer cartExpenditureEventProducer,
	        ShoppingCartEventProducer shoppingCartEventProducer) {
		return new ShoppingCartCommandServiceImpl(
		        shoppingCartRepositoryAdapter,
		        productRepositoryAdapter,
		        new ValidationQueryServiceImpl(),
		        cartExpenditureEventProducer,
		        shoppingCartEventProducer);
	}
	
	@Bean
	public CartExpenditureQueryService cartExpenditureService(SpringDataJPACartExpenditureRepositoryAdapter repositoryAdapter) {
		return new CartExpenditureQueryServiceImpl(repositoryAdapter);
	}

}
