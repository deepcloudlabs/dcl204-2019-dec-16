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
		assertThrows(IllegalArgumentException.class, () -> acc.deposit(-10));
		assertEquals(1_000, acc.getBalance());
	}

	@Test
	void deposit_withPositiveAmount() {
		// Test Setup
		Account acc = new Account("TR1", 1_000);
		assertEquals("TR1", acc.getIban());
		assertEquals(1_000, acc.getBalance());
		// Exercise Method + Verify State
		acc.deposit(1);
		assertEquals(1_001, acc.getBalance());
	}

	@Test
	void withdraw_withNegativeAmount() {
		Account acc = new Account("TR1", 1_000);
		assertThrows(IllegalArgumentException.class, () -> acc.withdraw(-10));
		assertEquals(1_000, acc.getBalance());
	}

	@Test
	void withdraw_overBalance() {
		Account acc = new Account("TR1", 1_000);
		assertThrows(InsufficientBalanceException.class, () -> acc.withdraw(1_001));
		assertEquals(1_000, acc.getBalance());
	}

	@Test
	void withdraw_allBalance() throws InsufficientBalanceException {
		Account acc = new Account("TR1", 1_000);
		acc.withdraw(1_000);
		assertEquals(0, acc.getBalance());
	}

}
