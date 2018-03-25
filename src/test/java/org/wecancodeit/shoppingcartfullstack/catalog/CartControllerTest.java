package org.wecancodeit.shoppingcartfullstack.catalog;

import static org.hamcrest.Matchers.any;
import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;
import static org.mockito.Mockito.when;

import java.util.Collections;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class CartControllerTest {

	@InjectMocks
	CartController underTest;

	@Mock
	private CartItemRepository cartItemRepo;

	@Mock
	private CartItem cartItem;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldDisplayCart() {
		when(cartItemRepo.findAll()).thenReturn(Collections.singleton(cartItem));

		Iterable<CartItem> result = underTest.displayCart();

		assertThat(result, contains(any(CartItem.class)));
	}

}
