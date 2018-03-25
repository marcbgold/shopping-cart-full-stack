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
public class CartItemJpaTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ProductRepository productRepo;

	// @Resource
	// private TagRepository tagRepo;

	@Resource
	private CartItemRepository cartItemRepo;

	@Test
	public void shouldCreateAndAssignProductToCartItem() {
		Product product = new Product("test");
		product = productRepo.save(product);
		CartItem cartItem = new CartItem(product, 1);
		cartItem = cartItemRepo.save(cartItem);

		entityManager.flush();
		entityManager.clear();

		assertThat(cartItem.getProduct(), is(product));
	}

}
