package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Collection;

import org.springframework.data.repository.CrudRepository;

public interface CartItemRepository extends CrudRepository<CartItem, Long> {

	Collection<CartItem> findByCart(Cart cart);

}
