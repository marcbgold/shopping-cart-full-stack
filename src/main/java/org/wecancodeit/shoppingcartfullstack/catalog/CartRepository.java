package org.wecancodeit.shoppingcartfullstack.catalog;

import org.springframework.data.repository.CrudRepository;

public interface CartRepository extends CrudRepository<Cart, Long> {

	Cart findById(long id);

}
