package com.example.banking.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
class BankTest {

	@Test
	void createBank() {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		assertEquals(1, garanti.getId());
		assertEquals("Garanti Bankası A.Ş.", garanti.getName());
		assertEquals(0, garanti.getCustomers().size());
	}

	@Test
	void createCustomer() {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		assertEquals("1", jack.getIdentity());
		assertEquals("Jack Bauer", jack.getFullname());
		assertEquals(1, garanti.getCustomers().size());
	}

	@Test
	void transfer_existingIbans() {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		jack.addAccount(new Account("TR1",100_000));
		kate.addAccount(new CheckingAccount("TR2",200_000,50_000));
		assertEquals(2, garanti.getCustomers().size());
		assertTrue(garanti.transfer("TR1", "TR2", 25_000));
		assertEquals(75_000,jack.getAccount("TR1").get().getBalance());
		assertEquals(225_000,kate.getAccount("TR2").get().getBalance());
	}

}
