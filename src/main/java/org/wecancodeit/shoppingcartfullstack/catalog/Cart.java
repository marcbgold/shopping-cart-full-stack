package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Cart {

	@Id
	@GeneratedValue
	private long id;

	@JsonIgnore
	@OneToMany(mappedBy = "cart")
	private Collection<CartItem> cartItems;

	public Cart() {
	}

	public long getId() {
		return id;
	}

	public Collection<CartItem> getCartItems() {
		return cartItems;
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

		return id == ((Cart) obj).id;
	}


}
