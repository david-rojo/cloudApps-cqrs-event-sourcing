package es.urjc.code.cqrs;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.annotation.Bean;

import es.urjc.code.cqrs.domain.CartExpenditureEventProducer;
import es.urjc.code.cqrs.domain.CartExpenditureService;
import es.urjc.code.cqrs.domain.CartExpenditureServiceImpl;
import es.urjc.code.cqrs.domain.ProductService;
import es.urjc.code.cqrs.domain.ProductServiceImpl;
import es.urjc.code.cqrs.domain.ShoppingCartService;
import es.urjc.code.cqrs.domain.ShoppingCartServiceImpl;
import es.urjc.code.cqrs.infrastructure.CartExpenditureEventProducerAdapter;
import es.urjc.code.cqrs.infrastructure.SpringDataJPACartExpenditureRepositoryAdapter;
import es.urjc.code.cqrs.infrastructure.SpringDataJPAProductRepositoryAdapter;
import es.urjc.code.cqrs.infrastructure.SpringDataJPAShoppingCartRepositoryAdapter;
import es.urjc.code.cqrs.service.ValidationServiceImpl;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ShoppingCartService shoppingCartService(
	        SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
	        SpringDataJPAProductRepositoryAdapter productRepositoryAdapter,
	        CartExpenditureEventProducer cartExpenditureEventProducer) {
		return new ShoppingCartServiceImpl(
		        shoppingCartRepositoryAdapter,
		        productRepositoryAdapter,
		        new ValidationServiceImpl(),
		        cartExpenditureEventProducer);
	}

	@Bean
	public ProductService productService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
		return new ProductServiceImpl(repositoryAdapter);
	}
	
	@Bean
	public CartExpenditureService cartExpenditureService(SpringDataJPACartExpenditureRepositoryAdapter repositoryAdapter) {
		return new CartExpenditureServiceImpl(repositoryAdapter);
	}

	@Bean
	public CartExpenditureEventProducer cartExpenditureEventProducer(ApplicationEventPublisher producer) {
		return new CartExpenditureEventProducerAdapter(producer);
	}
}
