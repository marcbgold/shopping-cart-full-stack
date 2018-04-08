package org.wecancodeit.shoppingcartfullstack.catalog;

import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

	Iterable<CartItem> findByCart(Cart cart);
	
	

}
