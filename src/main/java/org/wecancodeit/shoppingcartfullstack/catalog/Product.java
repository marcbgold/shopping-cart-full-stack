package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Product {

	@Id
	@GeneratedValue
	private long id;

	private String name;

	@ManyToMany
	private Collection<Tag> tags;

	@SuppressWarnings("unused")
	private Product() {
	}

	public Product(String name, Tag... tags) {
		this.name = name;
		this.tags = new HashSet<>(Arrays.asList(tags));
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Tag> getTags() {
		return tags;
	}
}
