package org.wecancodeit.shoppingcartfullstack.catalog;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import org.junit.Before;
import org.junit.Test;

public class BrowseControllerTest {

	// @InjectMocks
	BrowseController underTest;

	@Before
	public void setup() {
		underTest = new BrowseController();
	}

	@Test
	public void shouldFindAllProducts() {
		Collection<Product> result = underTest.findAllProducts();

		assertThat(result.size(), is(greaterThan(0)));
	}

}
