package org.wecancodeit.shoppingcartfullstack.catalog;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

	@Resource
	private CartItemRepository cartItemRepo;

	@RequestMapping(path = "/cart")
	public Iterable<CartItem> displayCart() {
		return cartItemRepo.findAll();
	}
}
