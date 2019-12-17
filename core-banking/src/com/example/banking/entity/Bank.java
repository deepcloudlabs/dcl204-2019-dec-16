package com.example.banking.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Bank {
	private final int id;
	private final String name;
	private List<Customer> customers;

	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
		customers = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Customer> getCustomers() {
		return Collections.unmodifiableList(customers);
	}

	public Customer createCustomer(String identity, String fullname) {
		Customer customer = new Customer(identity, fullname);
		customers.add(customer);
		return customer;
	}

	public Optional<Customer> findCustomerByIdentity(String identity) {
		for (Customer customer : customers) {
			if (customer.getIdentity().equals(identity))
				return Optional.of(customer);
		}
		return Optional.empty();
	}

	public double getBalance() {
		double totalBalance = 0;
		for (Customer customer : customers) {
			totalBalance += customer.getBalance();
		}
		return totalBalance;
	}

	public Optional<Account> getAccount8(String iban) {
		return customers.stream().map(Customer::getAccounts).flatMap(List::stream)
				.filter(account -> account.getIban().equals(iban)).findFirst();
	}

	public Optional<Account> getAccount9(String iban) {
		return customers.stream().map(cust -> cust.getAccount(iban)).filter(Optional::isPresent).map(Optional::get)
				.findFirst();
	}

	public Optional<Account> getAccount(String iban) {
		for (Customer customer : customers) {
			Optional<Account> account = customer.getAccount(iban);
			if (account.isPresent())
				return account;
		}
		return Optional.empty();
	}

	public Account getAccountValue(String iban) {
		for (Customer customer : customers) {
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
