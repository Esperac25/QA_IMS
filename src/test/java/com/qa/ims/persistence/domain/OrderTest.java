package com.qa.ims.persistence.domain;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

import nl.jqno.equalsverifier.EqualsVerifier;

public class OrderTest {

	@Mock
	private Order mock = new Order(1L, 1L);
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}
	
	@Test
	public void getIdTest() {
		assertEquals(1L, mock.getId(), .01);
	}

	@Test
	public void setIdTest() {
		mock.setId(2L);
		assertEquals(2L, mock.getId(), .01);
	}

	@Test
	public void getCustomer_idTest() {
		assertEquals(1L, mock.getCustomer_id(), .01);
	}

	@Test
	public void setCustomer_idTest() {
		mock.setCustomer_id(2L);
		assertEquals(2L, mock.getCustomer_id(), .01);
	}
}