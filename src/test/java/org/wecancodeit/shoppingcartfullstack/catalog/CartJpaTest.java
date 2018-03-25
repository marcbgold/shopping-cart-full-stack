package org.wecancodeit.shoppingcartfullstack.catalog;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class CartJpaTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ProductRepository productRepo;

	@Resource
	private CartRepository cartRepo;

	@Resource
	private CartItemRepository cartItemRepo;

	@Test
	public void shouldCreateAndAssignProductToCartItem() {
		Cart cart = new Cart();
		cart = cartRepo.save(cart);
		Product product = new Product("test");
		product = productRepo.save(product);
		CartItem cartItem = new CartItem(cart, product, 1);
		cartItem = cartItemRepo.save(cartItem);

		entityManager.flush();
		entityManager.clear();

		assertThat(cartItem.getProduct(), is(product));
	}

	@Test
	public void shouldCreateAndAssignCartToCartItem() {
		Cart cart = new Cart();
		cart = cartRepo.save(cart);
		Product product = new Product("test");
		product = productRepo.save(product);
		CartItem cartItem = new CartItem(cart, product, 1);
		cartItem = cartItemRepo.save(cartItem);

		entityManager.flush();
		entityManager.clear();

		assertThat(cartItem.getCart(), is(cart));
	}

}
