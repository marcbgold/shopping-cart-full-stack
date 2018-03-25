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
	private Cart cart;

	@Mock
	private CartRepository cartRepo;

	@Mock
	private CartItem cartItem;

	@Mock
	private CartItemRepository cartItemRepo;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void shouldDisplayCart() {
		when(cartRepo.findById(1L)).thenReturn(cart);
		when(cartItemRepo.findByCart(cart)).thenReturn(Collections.singleton(cartItem));

		Iterable<CartItem> result = underTest.displayCart(1L);

		assertThat(result, contains(any(CartItem.class)));
	}

}
