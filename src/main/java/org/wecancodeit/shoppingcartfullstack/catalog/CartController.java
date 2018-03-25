package org.wecancodeit.shoppingcartfullstack.catalog;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

	@Resource
	private CartRepository cartRepo;

	@Resource
	private CartItemRepository cartItemRepo;

	@RequestMapping(path = "/cart/{id}")
	public Iterable<CartItem> displayCart(@PathVariable long id) {
		Cart foundCart = cartRepo.findById(id);
		return cartItemRepo.findByCart(foundCart);
	}
}
