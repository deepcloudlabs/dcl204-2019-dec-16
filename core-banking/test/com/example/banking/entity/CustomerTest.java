package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class CustomerTest {

	@Test
	void createCustomer() {
		Customer jack = new Customer("1", "Jack Bauer");
		assertEquals("1", jack.getIdentity());
		assertEquals("Jack Bauer", jack.getFullname());
		assertEquals(0, jack.getNumOfAccounts());
		jack.addAccount(new Account("TR1", 1_000));
		assertEquals(1, jack.getNumOfAccounts());
	}

	@Test
	void getAccount() {
		Customer jack = new Customer("1", "Jack Bauer");
		jack.addAccount(new Account("TR1", 1_000));
		jack.addAccount(new Account("TR2", 2_000));
		jack.addAccount(new Account("TR3", 3_000));
		assertEquals("1", jack.getIdentity());
		assertEquals("Jack Bauer", jack.getFullname());
		assertEquals(3, jack.getNumOfAccounts());
		assertTrue(jack.getAccount("TR1").isPresent());
		assertTrue(jack.getAccount("TR2").isPresent());
		assertTrue(jack.getAccount("TR3").isPresent());
		assertFalse(jack.getAccount("TR4").isPresent());
	}

	@Test
	void getBalance() {
		Customer jack = new Customer("1", "Jack Bauer");
		jack.addAccount(new Account("TR1", 1_000));
		jack.addAccount(new Account("TR2", 2_000));
		jack.addAccount(new Account("TR3", 3_000));
		assertEquals("1", jack.getIdentity());
		assertEquals("Jack Bauer", jack.getFullname());
		assertEquals(3, jack.getNumOfAccounts());
		assertEquals(6_000, jack.getBalance());
	}

	@Test
	void getBalance8() {
		Customer jack = new Customer("1", "Jack Bauer");
		jack.addAccount(new Account("TR1", 1_000));
		jack.addAccount(new Account("TR2", 2_000));
		jack.addAccount(new Account("TR3", 3_000));
		assertEquals("1", jack.getIdentity());
		assertEquals("Jack Bauer", jack.getFullname());
		assertEquals(3, jack.getNumOfAccounts());
		assertEquals(6_000, jack.getBalance8());
	}

}
