package org.wecancodeit.shoppingcartfullstack.catalog;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class CartItem {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	// @ManyToMany
	// private Collection<Tag> tags;

	@SuppressWarnings("unused")
	private CartItem() {
	}

	public CartItem(String name) {
		this.name = name;
		// this.tags = new HashSet<>(Arrays.asList(tags));
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

}
