package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Collection;
import java.util.Collections;

public class BrowseController {

	public Collection<Product> findProducts() {
		return Collections.singleton(new Product());
	}

}
