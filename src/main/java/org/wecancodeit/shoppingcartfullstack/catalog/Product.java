package org.wecancodeit.shoppingcartfullstack.catalog;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Product {

	@Id
	private long id;

	private String name;

	@SuppressWarnings("unused")
	private Product() {
	}

	public Product(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}
}
