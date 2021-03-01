package es.urjc.code.cqrs.domain.service.command;

import java.util.UUID;

import org.modelmapper.ModelMapper;

import es.urjc.code.cqrs.domain.Product;
import es.urjc.code.cqrs.domain.ShoppingCart;
import es.urjc.code.cqrs.domain.ShoppingCartItem;
import es.urjc.code.cqrs.domain.ShoppingCartStatus;
import es.urjc.code.cqrs.domain.dto.FullProductDTO;
import es.urjc.code.cqrs.domain.dto.FullShoppingCartDTO;
import es.urjc.code.cqrs.domain.dto.ShoppingCartDTO;
import es.urjc.code.cqrs.domain.repository.ProductRepository;
import es.urjc.code.cqrs.domain.repository.ShoppingCartRepository;
import es.urjc.code.cqrs.domain.service.query.ValidationQueryService;
import es.urjc.code.cqrs.service.event.CartExpenditureEventProducer;
import es.urjc.code.cqrs.service.event.ShoppingCartEventProducer;
import es.urjc.code.cqrs.service.event.model.CompletedCartEvent;
import es.urjc.code.cqrs.service.event.model.DeletedCartEvent;
import es.urjc.code.cqrs.service.event.model.SavedCartEvent;

public class ShoppingCartCommandServiceImpl implements ShoppingCartCommandService {

	private ShoppingCartRepository shoppingCartRepository;
	private ProductRepository productRepository;
	private ValidationQueryService validationService;
	private CartExpenditureEventProducer cartExpenditureEventProducer;
	private ShoppingCartEventProducer shoppingCartEventProducer;
	
	private ModelMapper mapper = new ModelMapper();

	public ShoppingCartCommandServiceImpl(ShoppingCartRepository shoppingCartRepository,
	        ProductRepository productRepository,
	        ValidationQueryService validationService,
	        CartExpenditureEventProducer cartExpenditureEventProducer,
	        ShoppingCartEventProducer shoppingCartEventProducer) {
		this.shoppingCartRepository = shoppingCartRepository;
		this.productRepository = productRepository;
		this.validationService = validationService;
		this.cartExpenditureEventProducer = cartExpenditureEventProducer;
		this.shoppingCartEventProducer = shoppingCartEventProducer;
	}
	
	private FullShoppingCartDTO saveShoppingCart(FullShoppingCartDTO fullShoppingCartDTO) {
		shoppingCartEventProducer.send(mapper.map(fullShoppingCartDTO, SavedCartEvent.class));
		return mapper.map(fullShoppingCartDTO, FullShoppingCartDTO.class);
	}

	@Override
	public FullShoppingCartDTO createShoppingCart() {
		ShoppingCart shoppingCart = new ShoppingCart();
		FullShoppingCartDTO fullShoppingCartDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);
		fullShoppingCartDTO.setId(UUID.randomUUID());
		return saveShoppingCart(fullShoppingCartDTO);
	}

	@Override
	public FullShoppingCartDTO updateShoppingCart(UUID id, ShoppingCartDTO shoppingCartDTO) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(id);

		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		ShoppingCart updateShoppingCart = mapper.map(shoppingCartDTO, ShoppingCart.class);

		if (updateShoppingCart.getStatus() != null &&
		        updateShoppingCart.getStatus() == ShoppingCartStatus.COMPLETED) {
			shoppingCart.setValidationService(validationService);
			shoppingCart.validate();
		}

		FullShoppingCartDTO fullSavedShoppingCartDTO = saveShoppingCart(
				mapper.map(shoppingCart, FullShoppingCartDTO.class));
		
		if (shoppingCart.isCompleted()) {
			cartExpenditureEventProducer.send(new CompletedCartEvent(
					fullSavedShoppingCartDTO.getId(),
					fullSavedShoppingCartDTO.getPrice()));
		}		
		
		return fullSavedShoppingCartDTO;
	}

	@Override
	public FullShoppingCartDTO deleteShoppingCart(UUID id) {
		FullShoppingCartDTO shoppingCart = shoppingCartRepository.findById(id);
		shoppingCartEventProducer.send(mapper.map(shoppingCart, DeletedCartEvent.class));
		return shoppingCart;
	}

	@Override
	public FullShoppingCartDTO addProduct(UUID idShoppingCart, UUID idProduct, int quantity) {
		FullProductDTO fullProductDTO = productRepository.findById(idProduct);
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

		return addProduct(fullProductDTO, fullShoppingCartDTO, quantity);
	}

	public FullShoppingCartDTO addProduct(FullProductDTO fullProductDTO, FullShoppingCartDTO fullShoppingCartDTO,
	        int quantity) {
		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(fullProductDTO.getId());

		ShoppingCartItem shoppingCartItem = new ShoppingCartItem(
		        mapper.map(fullProductDTO, Product.class),
		        quantity);
		shoppingCartItem.setId(UUID.randomUUID());
		shoppingCart.addItem(shoppingCartItem);

		FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

		return saveShoppingCart(newFullProductDTO);
	}

	@Override
	public FullShoppingCartDTO deleteProduct(UUID idShoppingCart, UUID idProduct) {
		FullShoppingCartDTO fullShoppingCartDTO = shoppingCartRepository.findById(idShoppingCart);

		ShoppingCart shoppingCart = mapper.map(fullShoppingCartDTO, ShoppingCart.class);
		shoppingCart.removeItem(idProduct);

		FullShoppingCartDTO newFullProductDTO = mapper.map(shoppingCart, FullShoppingCartDTO.class);

		return saveShoppingCart(newFullProductDTO);
	}
}
