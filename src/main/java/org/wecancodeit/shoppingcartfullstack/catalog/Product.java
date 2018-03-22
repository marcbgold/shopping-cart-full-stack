package org.wecancodeit.shoppingcartfullstack.catalog;

//@Entity
public class Product {

	// @Id
	// private long id;

	private String name;

	@SuppressWarnings("unused")
	private Product() {
	}

	public Product(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}
}
