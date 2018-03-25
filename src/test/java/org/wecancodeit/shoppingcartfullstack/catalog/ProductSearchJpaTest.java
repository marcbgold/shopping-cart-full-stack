package org.wecancodeit.shoppingcartfullstack.catalog;

import static org.hamcrest.Matchers.contains;
import static org.junit.Assert.assertThat;

import java.util.Collection;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@DataJpaTest
public class ProductSearchJpaTest {

	@Resource
	private TestEntityManager entityManager;

	@Resource
	private ProductRepository productRepo;

	@Resource
	private TagRepository tagRepo;

	@Test
	public void shouldCreateAndAssignTagToNewProduct() {
		Tag tag = new Tag("test tag");
		tag = tagRepo.save(tag);
		Product product = new Product("test", tag);
		product = productRepo.save(product);

		entityManager.flush();
		entityManager.clear();

		assertThat(product.getTags(), contains(tag));
	}

	@Test
	public void shouldFindItemByTagDescription() {
		Tag tag = new Tag("description");
		tag = tagRepo.save(tag);
		Product product = new Product("test", tag);
		product = productRepo.save(product);

		entityManager.flush();
		entityManager.clear();

		Collection<Product> results = productRepo.findByTagsContaining(tag);

		assertThat(results, contains(product));
	}

}
