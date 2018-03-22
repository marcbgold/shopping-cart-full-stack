package org.wecancodeit.shoppingcartfullstack.catalog;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	@Resource
	private ProductRepository productRepo;

	@RequestMapping("/products")
	public Iterable<Product> findAllProducts() {
		return productRepo.findAll();
	}

	@RequestMapping("/products/{id}")
	public Product findProductById(@PathVariable long id) {
		return new Product("test");
	}

}
