package es.urjc.code.cqrs;

import org.springframework.context.annotation.Bean;

import es.urjc.code.cqrs.domain.ProductService;
import es.urjc.code.cqrs.domain.ProductServiceImpl;
import es.urjc.code.cqrs.domain.ShoppingCartService;
import es.urjc.code.cqrs.domain.ShoppingCartServiceImpl;
import es.urjc.code.cqrs.infrastructure.SpringDataJPAProductRepositoryAdapter;
import es.urjc.code.cqrs.infrastructure.SpringDataJPAShoppingCartRepositoryAdapter;
import es.urjc.code.cqrs.service.ValidationServiceImpl;

@org.springframework.context.annotation.Configuration
public class Configuration {

	@Bean
	public ShoppingCartService shoppingCartService(
	        SpringDataJPAShoppingCartRepositoryAdapter shoppingCartRepositoryAdapter,
	        SpringDataJPAProductRepositoryAdapter productRepositoryAdapter) {
		return new ShoppingCartServiceImpl(
		        shoppingCartRepositoryAdapter,
		        productRepositoryAdapter,
		        new ValidationServiceImpl());
	}

	@Bean
	public ProductService productService(SpringDataJPAProductRepositoryAdapter repositoryAdapter) {
		return new ProductServiceImpl(repositoryAdapter);
	}

}
