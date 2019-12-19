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
		assertThrows(IllegalArgumentException.class, () -> acc.withdraw(-10));
		assertEquals(1_000, acc.getBalance());
	}

	@Test
	void withdraw_OverBalanceSuccess() throws InsufficientBalanceException {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		assertEquals("TR1", acc.getIban());
		assertEquals(1_000, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
		acc.withdraw(1_500);
		assertEquals(-500, acc.getBalance());
	}

	@Test
	void withdraw_OverBalanceFailure() {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		assertEquals("TR1", acc.getIban());
		assertEquals(1_000, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
		assertThrows(InsufficientBalanceException.class, () -> acc.withdraw(1_501));
		assertEquals(1_000, acc.getBalance());
	}

	@Test
	void withdraw_AllBalanceSuccess() throws InsufficientBalanceException {
		CheckingAccount acc = new CheckingAccount("TR1", 1_000, 500);
		assertEquals("TR1", acc.getIban());
		assertEquals(1_000, acc.getBalance());
		assertEquals(500, acc.getOverdraftAmount());
		acc.withdraw(1000);
		assertEquals(0, acc.getBalance());
	}
}
