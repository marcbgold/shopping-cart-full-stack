package org.wecancodeit.shoppingcartfullstack;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

@RunWith(SpringRunner.class)
@WebMvcTest // (BrowseController.class)
public class BrowseMvcTest {

	@Resource
	private MockMvc mvc;

	@Test
	public void shouldDisplayCart() throws Exception {
		mvc.perform(get("/cart")).andExpect(status().isOk());
	}
}
