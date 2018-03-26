package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {

	Collection<Product> findByName(String name);

	Collection<Product> findByTagsContaining(Tag input);
	

}
