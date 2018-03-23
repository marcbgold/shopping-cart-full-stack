package org.wecancodeit.shoppingcartfullstack.catalog;

import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class SearchControllerTest {

	@InjectMocks
	SearchController underTest;

	@Mock
	ProductRepository productRepo;

	@Mock
	Product product1;

	@Mock
	Product product2;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldFindProductsByNameFromDatabase() {
		when(productRepo.findByName("test")).thenReturn(new ArrayList<Product>(Arrays.asList(product1, product2)));

		Collection<Product> results = underTest.findProductByName("test");

		assertThat(results, containsInAnyOrder(product1, product2));
	}

	@Test
	public void shouldReturnEmptyCollectionWhenProductNameNotFound() {
		// when(productRepo.findByName("notFound")).thenReturn(new
		// ArrayList<Product>());

		Collection<Product> results = underTest.findProductByName("notFound");
		assertThat(results.isEmpty(), is(true));

	}

}
