package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Collection;

import org.mockito.Mock;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	@Mock
	private ProductRepository productRepo;

	@RequestMapping("/search")
	public Collection<Product> findProductByName(String input) {
		return productRepo.findByName(input);
	}

}
