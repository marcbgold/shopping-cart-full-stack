package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.wecancodeit.shoppingcartfullstack.catalog.Product;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class ContainerRestTest {

	@Resource
	private TestRestTemplate restTemplate;

	@Test
	public void shouldDisplayProducts() {
		ResponseEntity<String> response = restTemplate.getForEntity("/products", String.class);

		HttpStatus status = response.getStatusCode();

		assertThat(status, is(HttpStatus.OK));
	}

	@Test
	public void shouldCreateNewProduct() {
		Product product = new Product("test");

		ResponseEntity<Product> response = restTemplate.postForEntity("/products", product, Product.class);

		assertThat(response.getBody().getId(), is(greaterThan(0L)));
	}

	@Test
	public void shouldDisplaySearchResults() {
		ResponseEntity<String> response = restTemplate.getForEntity("/search", String.class);

		HttpStatus status = response.getStatusCode();

		assertThat(status, is(HttpStatus.OK));
	}
}
