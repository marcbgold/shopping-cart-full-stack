package org.wecancodeit.shoppingcartfullstack.catalog;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest(CartController.class)
public class CartMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private CartItemRepository cartitemRepo;

	@Test
	public void shouldDisplayCart() throws Exception {
		mvc.perform(get("/cart")).andExpect(status().isOk());
	}

}
