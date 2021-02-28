package es.urjc.code.cqrs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.modelmapper.ModelMapper;

import es.urjc.code.cqrs.domain.CartExpenditureEventProducer;
import es.urjc.code.cqrs.domain.FullProductDTO;
import es.urjc.code.cqrs.domain.FullShoppingCartDTO;
import es.urjc.code.cqrs.domain.FullShoppingCartItemDTO;
import es.urjc.code.cqrs.domain.Product;
import es.urjc.code.cqrs.domain.ProductDTO;
import es.urjc.code.cqrs.domain.ProductRepository;
import es.urjc.code.cqrs.domain.ProductServiceImpl;
import es.urjc.code.cqrs.domain.ShoppingCartRepository;
import es.urjc.code.cqrs.domain.ShoppingCartServiceImpl;
import es.urjc.code.cqrs.service.ValidationServiceImpl;

@TestMethodOrder(OrderAnnotation.class)
public class ShoppingCartService {
	
	private ProductRepository productRepository;
	private ProductServiceImpl productService;
	private ShoppingCartRepository shoppingCartRepository;
	private ShoppingCartServiceImpl shoppingCartService;
	private ModelMapper mapper = new ModelMapper();
	
	private CartExpenditureEventProducer eventProducer;
	
	private static FullShoppingCartDTO createdShoppingCart;
	
	@BeforeEach
	void setUp() {
		productRepository = mock(ProductRepository.class);
		shoppingCartRepository = mock(ShoppingCartRepository.class);
		eventProducer = mock(CartExpenditureEventProducer.class);
		
		productService = new ProductServiceImpl(productRepository);
		shoppingCartService = new ShoppingCartServiceImpl(
				shoppingCartRepository,
		        productRepository,
		        new ValidationServiceImpl(), 
		        eventProducer);
	}
	
	@Test
	@Order(1)
	void shoppingCartCanBeAdded() {
		createdShoppingCart = shoppingCartService.createShoppingCart();
		verify(shoppingCartRepository).save(createdShoppingCart);
	}
	
	@Test
	@Order(2)
	void productCanBeAddedToShoppingCart() {
		Product product = new Product(
		        "PLUMÍFERO MONTAÑA Y SENDERISMO FORCLAZ TREK100 AZUL CAPUCHA",
		        "Esta chaqueta acolchada de plumón y plumas, con certificado RDS, abriga bien durante un vivac entre +5 °C y -5 °C.",
		        49.99);
		ProductDTO productDTO = mapper.map(product, ProductDTO.class);

		FullProductDTO fullProductDTO = productService.createProduct(productDTO);
		verify(productRepository).save(fullProductDTO);
		
		int items = Math.abs(new Random().nextInt());
				
		createdShoppingCart = shoppingCartService.addProduct(fullProductDTO, createdShoppingCart, items);
		FullShoppingCartItemDTO fullShoppingCartItemDTO = createdShoppingCart.getItems().get(0);

		assertEquals(fullShoppingCartItemDTO.getQuantity(), items);
		assertEquals(fullShoppingCartItemDTO.getTotalPrice(), items * productDTO.getPrice());
	}
	
	@Test
	@Order(3)
	void shoppingCartCanBeDeleted() {
		shoppingCartService.deleteShoppingCart(createdShoppingCart.getId());
		verify(shoppingCartRepository).deleteById(createdShoppingCart.getId());
	}
}
