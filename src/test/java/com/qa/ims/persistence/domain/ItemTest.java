package com.qa.ims.persistence.domain;

import org.junit.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertEquals;

import nl.jqno.equalsverifier.EqualsVerifier;

public class ItemTest {
	
	@Mock
	private Item mock = new Item(1L, "couch", 200.00);
	
	@Test
	public void testEquals() {
		EqualsVerifier.simple().forClass(Item.class).verify();
	}
	
	@Test
	public void getIdTest() {
		assertEquals(1L, mock.getId(), 0.1);
	}
	@Test
	public void setIdTest() {
		mock.setId(1L);
		assertEquals(1, mock.getId(), .01);
	}
	@Test
	public void getNameTest() {
		assertEquals("couch", mock.getName());
	}
	@Test
	public void setNameTest() {
		mock.setName("loveseat");
		assertEquals("loveseat", mock.getName());
	}
	@Test
	public void getCostTest() {
		assertEquals((double)200.00, (double) mock.getCost(), .01);
	}
	
	@Test
	public void setCostTest() {
		mock.setCost(100.00);
		assertEquals((double)100.00, (double) mock.getCost(), .01);
	}
}
	
