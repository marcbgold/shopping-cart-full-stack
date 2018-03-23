package org.wecancodeit.shoppingcartfullstack.catalog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MaintenanceControllerTest {

	@InjectMocks
	MaintenanceController underTest;

	@Mock
	private ProductRepository productRepo;

	@Mock
	private Product incomingProduct;

	@Mock
	private Product persistentProduct;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldCreateNewProduct() {
		when(productRepo.save(incomingProduct)).thenReturn(persistentProduct);

		Product result = underTest.addNewProduct(incomingProduct);

		assertThat(result, is(persistentProduct));
	}

}
