package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
class CheckingAccountTest {

	@Test
	void withdraw_withNegativeAmount() {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		assertEquals("TR1", acc.getIban());
		assertEquals(1_000, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
		assertFalse(acc.withdraw(-1));
		assertEquals(1_000, acc.getBalance());
	}

	@Test
	void withdraw_OverBalanceSuccess() {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		assertEquals("TR1", acc.getIban());
		assertEquals(1_000, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
		assertTrue(acc.withdraw(1500));
		assertEquals(-500, acc.getBalance());
	}

	@Test
	void withdraw_OverBalanceFailure() {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		assertEquals("TR1", acc.getIban());
		assertEquals(1_000, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
		assertFalse(acc.withdraw(1501));
		assertEquals(1_000, acc.getBalance());
	}

	@Test
	void withdraw_AllBalanceSuccess() {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		assertEquals("TR1", acc.getIban());
		assertEquals(1_000, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
		assertTrue(acc.withdraw(1000));
		assertEquals(0, acc.getBalance());
	}
}
