package com.generali.burritoorderingservice;

import com.generali.burritoorderingservice.dao.OrderRepository;
import com.generali.burritoorderingservice.model.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class TheOrderRepositoryTests {

	@Autowired
	private TestEntityManager entityManager;

	@Autowired
	private OrderRepository repository;

	@Test
	public void testFindByDescription() {

		TheOrder theOrder = TestUtil.buildOrder("first order");

		TheOrder dbOrder = entityManager.persist(theOrder);

		Assertions.assertEquals(theOrder.getDescription(), dbOrder.getDescription());

		Assertions.assertEquals(theOrder.getProtein().getType(), dbOrder.getProtein().getType());

		List<TheOrder> theOrders = repository.findByDescription(theOrder.getDescription());

		assertThat(theOrders).extracting(TheOrder::getDescription).containsOnly(theOrder.getDescription());
	}

	@Test
	public void testFindById(){
		TheOrder theOrder = TestUtil.buildOrder("second order");

		TheOrder dbOrder = entityManager.persist(theOrder);

		Assertions.assertEquals(theOrder.getId(), dbOrder.getId());
		Assertions.assertEquals(theOrder.getDescription(), dbOrder.getDescription());
		Assertions.assertEquals(theOrder.getProtein().getType(), dbOrder.getProtein().getType());

		TheOrder foundOrder = repository.findById(dbOrder.getId()).get();
		Assertions.assertEquals(dbOrder.getDescription(), foundOrder.getDescription());
	}

}
