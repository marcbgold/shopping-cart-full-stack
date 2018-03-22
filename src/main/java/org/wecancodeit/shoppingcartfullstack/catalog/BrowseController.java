package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Collection;
import java.util.Collections;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BrowseController {

	@RequestMapping("/products")
	public Collection<Product> findAllProducts() {
		return Collections.singleton(new Product("test"));
	}

}
