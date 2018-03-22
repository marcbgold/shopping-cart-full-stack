package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Collection;
import java.util.Collections;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	// @Resource
	// private ProductRepository productRepo;

	@RequestMapping("/products")
	public Collection<Product> findAllProducts() {
		return Collections.singleton(new Product("test"));
	}

	@RequestMapping("/products/{id}")
	public Product findProductById(@PathVariable long id) {
		return new Product("test");
	}

}
