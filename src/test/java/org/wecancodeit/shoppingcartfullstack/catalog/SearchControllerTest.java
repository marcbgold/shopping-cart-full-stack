package org.wecancodeit.shoppingcartfullstack.catalog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;

public class SearchControllerTest {

	// @InjectMocks
	SearchController underTest;

	@Before
	public void setup() {
		underTest = new SearchController();
		// MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldSearchAndFindOneProductByName() {
		Product result = underTest.findProductByName("test");

		assertThat(result.getName(), is("test"));
	}

}
