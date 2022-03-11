package com.generali.burritoorderingservice;

import com.generali.burritoorderingservice.controller.BurritoController;
import com.generali.burritoorderingservice.dao.OrderRepository;
import com.generali.burritoorderingservice.model.TheOrder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(BurritoController.class)
class BurritoControllerTests {

	@Autowired
	private MockMvc mvc;

	@MockBean
	private OrderRepository repository;

	@Test
	public void testGetOrderAPI() throws Exception {
		final String desc = "test order";
		TheOrder order = TestUtil.buildOrder(desc);
		order.setId(1L);

		given(repository.findById(Mockito.any())).willReturn(java.util.Optional.of(order));

		mvc.perform(MockMvcRequestBuilders
				.get("/orders/{orderId}", 1L)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(order.getId()))
				.andExpect(MockMvcResultMatchers.jsonPath("$.description").value(desc))
				.andExpect(MockMvcResultMatchers.jsonPath("$.tortilla.type").value(order.getTortilla().getType()));

		verify(repository, VerificationModeFactory.times(1)).findById(Mockito.any());
	}

	@Test
	public void testPostOrderAPI() throws Exception
	{
		final String desc = "test post order";
		TheOrder order = TestUtil.buildOrder(desc);
		order.setId(2L);

		given(repository.save(Mockito.any())).willReturn(order);

		mvc.perform( MockMvcRequestBuilders
				.post("/orders")
				.content(TestUtil.asJsonString(order))
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(MockMvcResultMatchers.jsonPath("$.id").value(2L))
				.andExpect(MockMvcResultMatchers.jsonPath("$.description").value(desc))
				.andExpect(MockMvcResultMatchers.jsonPath("$.protein.type").value(order.getProtein().getType()));

		verify(repository, VerificationModeFactory.times(1)).save(Mockito.any());
	}

}
