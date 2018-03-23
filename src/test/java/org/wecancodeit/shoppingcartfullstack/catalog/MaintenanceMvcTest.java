package org.wecancodeit.shoppingcartfullstack.catalog;

import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(MaintenanceController.class)
public class MaintenanceMvcTest {

	@Resource
	private MockMvc mvc;

	@Resource
	private ObjectMapper jsonMapper;

	@MockBean
	private ProductRepository productRepo;

	@Test
	public void shouldCreateNewProduct() throws Exception {
		Product product = new Product("test");
		String productJson = jsonMapper.writeValueAsString(product);
		mvc.perform(post("/products").content(productJson)).andExpect(status().isOk());
	}

	@Test
	public void shouldReturnSameProductWhenCreatingNewProduct() throws Exception {
		when(productRepo.save(any(Product.class))).thenReturn(new Product("test"));

		Product product = new Product("test");
		String productJson = jsonMapper.writeValueAsString(product);

		MockHttpServletRequestBuilder request = (post("/products").content(productJson));
		mvc.perform(request).andExpect(jsonPath("@.name", is("test")));
	}
}
