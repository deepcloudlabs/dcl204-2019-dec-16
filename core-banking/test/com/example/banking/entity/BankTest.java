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
	void transfer_existingIbans() throws InsufficientBalanceException {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		jack.addAccount(new Account("TR1", 100_000));
		kate.addAccount(new CheckingAccount("TR2", 200_000, 50_000));
		assertEquals(2, garanti.getCustomers().size());
		garanti.transfer("TR1", "TR2", 25_000);
		assertEquals(75_000, jack.getAccount("TR1").get().getBalance());
		assertEquals(225_000, kate.getAccount("TR2").get().getBalance());
	}

	@Test
	void transfer_nonexistingIbans() throws InsufficientBalanceException {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		jack.addAccount(new Account("TR1", 100_000));
		kate.addAccount(new CheckingAccount("TR2", 200_000, 50_000));
		assertEquals(2, garanti.getCustomers().size());
		assertThrows(AccountNotFoundException.class, () -> garanti.transfer("TR1", "TR3", 25_000));
		assertThrows(AccountNotFoundException.class, () -> garanti.transfer("TR3", "TR2", 25_000));
		assertEquals(100_000, jack.getAccount("TR1").get().getBalance());
		assertEquals(200_000, kate.getAccount("TR2").get().getBalance());
	}

	@Test
	void transferBetweenExistingIbansWithInsufficientBalance() throws InsufficientBalanceException {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		jack.addAccount(new Account("TR1", 100_000));
		kate.addAccount(new CheckingAccount("TR2", 200_000, 50_000));
		assertEquals(2, garanti.getCustomers().size());
		assertThrows(InsufficientBalanceException.class, () -> garanti.transfer("TR1", "TR2", 250_000));
		assertEquals(100_000, jack.getAccount("TR1").get().getBalance());
		assertEquals(200_000, kate.getAccount("TR2").get().getBalance());
	}

	@Test
	void transfer_negativeAmount() {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		jack.addAccount(new Account("TR1", 100_000));
		kate.addAccount(new CheckingAccount("TR2", 200_000, 50_000));
		assertEquals(2, garanti.getCustomers().size());
		assertThrows(IllegalArgumentException.class, () -> garanti.transfer("TR1", "TR2", -5_000));
	}

	@Test
	void getBalance() {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		jack.addAccount(new Account("TR1", 100_000));
		jack.addAccount(new CheckingAccount("TR2", 200_000, 20_000));
		assertEquals(2, jack.getNumOfAccounts());
		kate.addAccount(new CheckingAccount("TR3", 300_000, 30_000));
		kate.addAccount(new Account("TR4", 400_000));
		assertEquals(2, kate.getNumOfAccounts());
		assertEquals(2, garanti.getCustomers().size());
		assertEquals(1_000_000, garanti.getBalance());
	}

	@Test
	void getCustomer() {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		jack.addAccount(new Account("TR1", 100_000));
		jack.addAccount(new CheckingAccount("TR2", 200_000, 20_000));
		assertEquals(2, jack.getNumOfAccounts());
		kate.addAccount(new CheckingAccount("TR3", 300_000, 30_000));
		kate.addAccount(new Account("TR4", 400_000));
		assertEquals(2, kate.getNumOfAccounts());
		assertEquals(2, garanti.getCustomers().size());
		assertTrue(garanti.findCustomerByIdentity("1").isPresent());
		assertTrue(garanti.findCustomerByIdentity("2").isPresent());
		assertFalse(garanti.findCustomerByIdentity("3").isPresent());
	}

	@Test
	void getAccount() {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		jack.addAccount(new Account("TR1", 100_000));
		jack.addAccount(new CheckingAccount("TR2", 200_000, 20_000));
		assertEquals(2, jack.getNumOfAccounts());
		kate.addAccount(new CheckingAccount("TR3", 300_000, 30_000));
		kate.addAccount(new Account("TR4", 400_000));
		assertEquals(2, kate.getNumOfAccounts());
		assertEquals(2, garanti.getCustomers().size());
		assertEquals("TR1",garanti.getAccount("TR1").getIban());
		assertEquals("TR2",garanti.getAccount("TR2").getIban());
		assertEquals("TR3",garanti.getAccount("TR3").getIban());
		assertEquals("TR4",garanti.getAccount("TR4").getIban());
		assertThrows( AccountNotFoundException.class, () -> garanti.getAccount("TR5"));
		assertTrue(garanti.getAccount9("TR1").isPresent());
		assertTrue(garanti.getAccount9("TR2").isPresent());
		assertTrue(garanti.getAccount9("TR3").isPresent());
		assertTrue(garanti.getAccount9("TR4").isPresent());
		assertFalse(garanti.getAccount9("TR5").isPresent());
		assertTrue(garanti.getAccount8("TR1").isPresent());
		assertTrue(garanti.getAccount8("TR2").isPresent());
		assertTrue(garanti.getAccount8("TR3").isPresent());
		assertTrue(garanti.getAccount8("TR4").isPresent());
		assertFalse(garanti.getAccount8("TR5").isPresent());
		assertNotNull(garanti.getAccountValue("TR1"));
		assertNotNull(garanti.getAccountValue("TR1"));
		assertNotNull(garanti.getAccountValue("TR2"));
		assertNotNull(garanti.getAccountValue("TR3"));
		assertNotNull(garanti.getAccountValue("TR4"));
		assertNull(garanti.getAccountValue("TR5"));
	}

}
