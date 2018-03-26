package org.wecancodeit.shoppingcartfullstack.catalog;

import java.util.Collection;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Tag {

	@Id
	@GeneratedValue
	private long id;
	private String name;

	@JsonIgnore
	@ManyToMany(mappedBy = "tags")
	private Set<Product> products;


	@SuppressWarnings("unused")
	private Tag() {
	}

	public Tag(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public Collection<Product> getProducts() {
		return products;
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

		return id == ((Tag) obj).id;
	}
}
