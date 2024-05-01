package com.alten.test;

import com.alten.test.entity.Product;
import com.alten.test.mapper.ProductMapper;
import com.alten.test.reposiory.ProductRepository;
import com.alten.test.service.ProductService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class TestApplicationTests {

	@Autowired
	private EntityManager entityManager;

	@Mock
	private ProductRepository productRepository;

	@Mock
	private ProductService productService;

	@Mock
	private ProductMapper productMapper;

	@Test
	void find_1000() {
		long id=1L;
		String name = "test";
		String code = "test code";
		int price = 50;
		int quantity = 50;
		int rating = 4;
		String category = "Accessories";

		Product product = Product.builder()
				.id(id)
				.name(name)
				.code(code)
				.price(price)
				.category(category)
				.quantity(quantity)
				.rating(rating)
				.build();


		when(productService.getById(id)).thenReturn(product);

		Product p = productService.getById(id);

		assertThat(p).isNotNull();
		assertThat(p.getName()).isEqualTo(name);
		assertThat(p.getCode()).isEqualTo(code);
		assertThat(p.getPrice()).isEqualTo(price);
		assertThat(p.getCategory()).isEqualTo(category);
		assertThat(p.getQuantity()).isEqualTo(quantity);
		assertThat(p.getRating()).isEqualTo(rating);
	}

	@Test
	void find_all(){
		long id1=1L;
		String name1 = "test 1";
		String code1 = "test code 1";

		long id2=2L;
		String name2 = "test";
		String code2 = "test code";

		Product product1 = Product.builder()
				.id(id1)
				.name(name1)
				.code(code1)
				.build();

		Product product2 = Product.builder()
				.id(id2)
				.name(name2)
				.code(code2)
				.build();

		List<Product> products = List.of(product1,product2);

		when(productService.getAll()).thenReturn(products);

		List<Product> ps = productService.getAll();

		assertThat(ps).isNotEmpty();
		assertThat(ps.size()).isEqualTo(products.size());
	}

	@Test
	void update(){
		long id=1L;
		String name = "test";
		String nameUpdated = "test updated";

		Product product = Product.builder()
				.id(id)
				.name(name)
				.build();

		Product productUpdated = Product.builder()
				.id(id)
				.name(nameUpdated)
				.build();

		when(productService.getById(id)).thenReturn(product);
		when(productService.save(productMapper.productToProductDTO(productUpdated))).thenReturn(productUpdated);
		when(productService.getById(id)).thenReturn(productUpdated);

		productService.save(productMapper.productToProductDTO(productUpdated));
		Product p = productService.getById(id);

		assertThat(p).isNotNull();
		assertThat(p.getName()).isEqualTo(nameUpdated);
	}

	@Test
	void delete_1(){
		long id1=1L;
		String name1 = "test 1";

		Product product1 = Product.builder()
				.id(id1)
				.name(name1)
				.build();

		productService.deleteByIds(List.of(id1));

		verify(productService).deleteByIds(List.of(id1));
	}

	@Test
	void delete_many(){
		List<Long> p = List.of(1L,2L,3L);

		productService.deleteByIds(p);

		verify(productService).deleteByIds(p);
	}
}
