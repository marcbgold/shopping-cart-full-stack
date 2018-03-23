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
@WebMvcTest(SearchController.class)
public class SearchMvcTest {

	@Resource
	private MockMvc mvc;

	@MockBean
	private ProductRepository productRepo;

	@Test
	public void shouldDisplaySearchResultsPage() throws Exception {
		mvc.perform(get("/search")).andExpect(status().isOk());
	}

}
