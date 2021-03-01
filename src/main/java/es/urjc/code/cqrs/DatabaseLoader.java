package es.urjc.code.cqrs;

import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import es.urjc.code.cqrs.domain.Product;
import es.urjc.code.cqrs.domain.dto.FullProductDTO;
import es.urjc.code.cqrs.domain.repository.ProductRepository;
import es.urjc.code.cqrs.domain.repository.ShoppingCartRepository;

@Controller
public class DatabaseLoader implements CommandLineRunner {

	@Autowired
	private ProductRepository productRepository;
	
	@Autowired
	private ShoppingCartRepository shoppingCartRepository;
	
	private ModelMapper mapper = new ModelMapper();
	

	@Override
	public void run(String... args) throws Exception {

		Product product1 = new Product(
		        "PLUMÍFERO MONTAÑA Y SENDERISMO FORCLAZ TREK100 AZUL CAPUCHA",
		        "Esta chaqueta acolchada de plumón y plumas, con certificado RDS, abriga bien durante un vivac entre +5 °C y -5 °C.",
		        49.99);

		Product product2 = new Product(
		        "PANTALÓN RUNNING RUN WARM",
		        "Hemos diseñado este pantalón para los hombres que corren con tiempo frío.",
		        19.0);

		Product product3 = new Product(
		        "ZAPATILLAS RUNNING",
		        "Nuestros equipos de diseño han desarrollado esta zapatilla de running ligera y con amortiguación para correr hasta 10 km a la semana.",
		        12.48);

		product1.setId(UUID.fromString("da242813-d3d7-43b2-9b07-70e4e1816a93"));
		product2.setId(UUID.fromString("79f2e84e-fd16-47ec-8e04-7c7fd5fb4c0c"));
		product3.setId(UUID.fromString("8bc0060c-1a62-4f15-8bf9-39e7a327f4a5"));
		
		productRepository.save(mapper.map(product1, FullProductDTO.class));
		productRepository.save(mapper.map(product2, FullProductDTO.class));
		productRepository.save(mapper.map(product3, FullProductDTO.class));		
		
	}

}
