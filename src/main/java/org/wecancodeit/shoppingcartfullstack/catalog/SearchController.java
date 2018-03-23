package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Collection;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	@Resource
	private ProductRepository productRepo;

	@RequestMapping("/search")
	public Collection<Product> findProductByName(String input) {
		return productRepo.findByName(input);
	}

	@RequestMapping("/search/{input}")
	public Collection<Product> findProductByTag(@PathVariable String input) {

		return productRepo.findByTagsContaining(input);
	}

}
