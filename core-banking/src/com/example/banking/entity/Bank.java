package com.example.banking.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Bank {
	private final int id;
	private final String name;
	private Map<String,Customer> customers;

	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
		customers = new HashMap<>();
	}

	public final int getId() {
		return id;
	}

	public final String getName() {
		return name;
	}

	public final Collection<Customer> getCustomers() {
		return customers.values();
	}

	public final Customer createCustomer(String identity, String fullname) {
		Customer customer = new Customer(identity, fullname);
		customers.put(identity,customer);
		return customer;
	}

	public Optional<Customer> findCustomerByIdentity(String identity) {
		return Optional.ofNullable(
				customers.get(identity));
	}

	public double getBalance() {
		double totalBalance = 0;
		for (Customer customer : customers.values()) {
			totalBalance += customer.getBalance();
		}
		return totalBalance;
	}

	public Optional<Account> getAccount8(String iban) {
		return customers.values().stream().map(Customer::getAccounts).flatMap(Collection::stream)
				.filter(account -> account.getIban().equals(iban)).findFirst();
	}

	public Optional<Account> getAccount9(String iban) {
		return customers.values().stream().map(cust -> cust.getAccount(iban)).filter(Optional::isPresent).map(Optional::get)
				.findFirst();
	}

	public Optional<Account> getAccount(String iban) {
		for (Customer customer : customers.values()) {
			Optional<Account> account = customer.getAccount(iban);
			if (account.isPresent())
				return account;
		}
		return Optional.empty();
	}

	public Account getAccountValue(String iban) {
		for (Customer customer : customers.values()) {
			Optional<Account> account = customer.getAccount(iban);
			if (account.isPresent())
				return account.get();
		}
		return null;
	}

	public boolean transfer(String fromIban, String toIban, double amount) {
		if (amount <= 0)
			return false;
		Optional<Account> fromAccount = getAccount(fromIban);
		Optional<Account> toAccount = getAccount(toIban);
		if (fromAccount.isPresent() && toAccount.isPresent()) {
			if (fromAccount.get().withdraw(amount)) {
				toAccount.get().deposit(amount);
				return true;
			}
		}
		return false;
	}

	public boolean transferValue(String fromIban, String toIban, double amount) {
		Account fromAccount = getAccountValue(fromIban);
		Account toAccount = getAccountValue(toIban);
		if (Objects.nonNull(fromAccount) && Objects.nonNull(toAccount)) {
			if (fromAccount.withdraw(amount)) {
				toAccount.deposit(amount);
				return true;
			}
		}
		return false;
	}
}
