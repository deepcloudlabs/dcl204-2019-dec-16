package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void createCustomer() {
		Customer jack=new Customer("1", "Jack Bauer");
		jack.getAccounts().add(new Account("TR1",1_000));
		assertEquals("1",jack.getIdentity());
		assertEquals("Jack Bauer",jack.getFullname());
		assertEquals(0, jack.getNumOfAccounts());
	}

}
