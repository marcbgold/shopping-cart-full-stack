package org.wecancodeit.shoppingcartfullstack.catalog;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CartController {

	@Resource
	private ProductRepository productRepo;

	@RequestMapping(path = "/cart", method = RequestMethod.GET)
	public Iterable<Product> displayCart() {
		return null;
	}
}
