package org.wecancodeit.shoppingcartfullstack.catalog;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	@RequestMapping("/search")
	public Product findProductByName(String input) {
		return new Product(input);
	}

}
