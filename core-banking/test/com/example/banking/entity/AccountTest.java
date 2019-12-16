package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AccountTest {

	@Test
	void deposit_withNegativeAmount() {
		// Test Setup
		Account acc = new Account("TR1", 1_000);
		assertEquals("TR1", acc.getIban());
		assertEquals(1_000, acc.getBalance());
		// Exercise Method + Verify State
		assertFalse(acc.deposit(-10));
		assertEquals(1_000, acc.getBalance());
	}

	@Test
	void deposit_withPositiveAmount() {
		// Test Setup
		Account acc = new Account("TR1", 1_000);
		assertEquals("TR1", acc.getIban());
		assertEquals(1_000, acc.getBalance());
		// Exercise Method + Verify State
		assertTrue(acc.deposit(1));
		assertEquals(1_001, acc.getBalance());
	}

	@Test
	void withdraw_withNegativeAmount() {
		Account acc = new Account("TR1", 1_000);
		assertFalse(acc.withdraw(-10));
		assertEquals(1_000, acc.getBalance());
	}
	@Test void withdraw_overBalance() {
		Account acc = new Account("TR1", 1_000);
		assertFalse(acc.withdraw(1_001));
		assertEquals(1_000, acc.getBalance());
	}
	@Test
	void withdraw_allBalance() {
		Account acc = new Account("TR1", 1_000);
		assertTrue(acc.withdraw(1_000));
		assertEquals(0, acc.getBalance());
	}

}
