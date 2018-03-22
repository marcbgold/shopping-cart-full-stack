package org.wecancodeit.shoppingcartfullstack.catalog;

import javax.annotation.Resource;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
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
		Product found = productRepo.findOne(id);

		if (found != null) {
			return found;
		}

		throw new ProductNotFoundException();
	}

	@SuppressWarnings("serial")
	@ResponseStatus(HttpStatus.NOT_FOUND)
	public class ProductNotFoundException extends RuntimeException {

	}

}
