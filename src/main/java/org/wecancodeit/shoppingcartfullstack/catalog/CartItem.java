package org.wecancodeit.shoppingcartfullstack.catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class CartItem {

	@Id
	@GeneratedValue
	private long id;

	@ManyToOne
	private Product product;
	private int quantity;

	@SuppressWarnings("unused")
	private CartItem() {
	}

	public CartItem(Product product, int quantity) {
		this.product = product;
		this.quantity = quantity;
	}

	public long getId() {
		return id;
	}

	public Product getProduct() {
		return product;
	}

	public int getQuantity() {
		return quantity;
	}

	@Override
	public int hashCode() {
		return ((Long) id).hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}

		return id == ((CartItem) obj).id;
	}

}
