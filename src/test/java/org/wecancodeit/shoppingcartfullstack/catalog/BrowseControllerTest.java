package org.wecancodeit.shoppingcartfullstack.catalog;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

public class BrowseControllerTest {

	@InjectMocks
	BrowseController underTest;

	// @Mock
	// private CrudRepository<Product, Long> productRepo;

	@Mock
	private Product product;

	@Before
	public void setup() {
		underTest = new BrowseController();
	}

	@Test
	public void shouldFindAllProducts() {
		Collection<Product> result = underTest.findAllProducts();

		assertThat(result.size(), is(greaterThan(0)));
	}

	@Test
	public void shouldFindOneProductById() {
		// when(productRepo.findOne(1L)).thenReturn(product);

		Product result = underTest.findProductById(1L);

		assertThat(result, is(not(nullValue())));
	}

}
