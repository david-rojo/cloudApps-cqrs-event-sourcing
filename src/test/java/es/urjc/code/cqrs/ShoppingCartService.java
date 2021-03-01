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

import es.urjc.code.cqrs.domain.Product;
import es.urjc.code.cqrs.domain.dto.FullProductDTO;
import es.urjc.code.cqrs.domain.dto.FullShoppingCartDTO;
import es.urjc.code.cqrs.domain.dto.FullShoppingCartItemDTO;
import es.urjc.code.cqrs.domain.dto.ProductDTO;
import es.urjc.code.cqrs.domain.repository.ProductRepository;
import es.urjc.code.cqrs.domain.repository.ShoppingCartRepository;
import es.urjc.code.cqrs.domain.service.command.ProductCommandServiceImpl;
import es.urjc.code.cqrs.domain.service.command.ShoppingCartCommandServiceImpl;
import es.urjc.code.cqrs.service.ValidationQueryServiceImpl;
import es.urjc.code.cqrs.service.event.CartExpenditureEventProducer;
import es.urjc.code.cqrs.service.event.ProductEventProducer;

@TestMethodOrder(OrderAnnotation.class)
public class ShoppingCartService {
	
	private ProductRepository productRepository;
	private ProductCommandServiceImpl productService;
	private ShoppingCartRepository shoppingCartRepository;
	private ShoppingCartCommandServiceImpl shoppingCartService;
	private ModelMapper mapper = new ModelMapper();
	
	private CartExpenditureEventProducer cartExpenditureEventProducer;
	private ProductEventProducer productEventProducer;
	
	private static FullShoppingCartDTO createdShoppingCart;
	
	@BeforeEach
	void setUp() {
		productRepository = mock(ProductRepository.class);
		shoppingCartRepository = mock(ShoppingCartRepository.class);
		cartExpenditureEventProducer = mock(CartExpenditureEventProducer.class);
		productEventProducer = mock(ProductEventProducer.class);
		
		productService = new ProductCommandServiceImpl(productRepository, productEventProducer);
		shoppingCartService = new ShoppingCartCommandServiceImpl(
				shoppingCartRepository,
		        productRepository,
		        new ValidationQueryServiceImpl(), 
		        cartExpenditureEventProducer);
	}
	
	@Test
	@Order(1)
	void shoppingCartCanBeAdded() {
		createdShoppingCart = shoppingCartService.createShoppingCart();
//		verify(shoppingCartRepository).save(createdShoppingCart);
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
//		verify(productRepository).save(fullProductDTO);
//		
//		int items = Math.abs(new Random().nextInt());
//				
//		createdShoppingCart = shoppingCartService.addProduct(fullProductDTO, createdShoppingCart, items);
//		FullShoppingCartItemDTO fullShoppingCartItemDTO = createdShoppingCart.getItems().get(0);
//
//		assertEquals(fullShoppingCartItemDTO.getQuantity(), items);
//		assertEquals(fullShoppingCartItemDTO.getTotalPrice(), items * productDTO.getPrice());
	}
	
	@Test
	@Order(3)
	void shoppingCartCanBeDeleted() {
		shoppingCartService.deleteShoppingCart(createdShoppingCart.getId());
//		verify(shoppingCartRepository).deleteById(createdShoppingCart.getId());
	}
}
