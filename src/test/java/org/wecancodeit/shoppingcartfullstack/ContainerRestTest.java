package org.wecancodeit.shoppingcartfullstack;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ContainerRestTest {

	@Resource
	private TestRestTemplate restTemplate;

	@Test
	public void shouldDisplayCart() {
		ResponseEntity<String> response = restTemplate.getForEntity("/cart", String.class);

		HttpStatus status = response.getStatusCode();

		assertThat(status, is(HttpStatus.OK));
	}
}
