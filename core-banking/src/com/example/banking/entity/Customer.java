package com.example.banking.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class Customer {
	private final String identity;
	private String fullname;
	private final List<Account> accounts;

	public Customer(String identity, String fullname) {
		this.identity = identity;
		this.fullname = fullname;
		this.accounts = new ArrayList<>();
	}

	public String getIdentity() {
		return identity;
	}

	public String getFullname() {
		return fullname;
	}

	public int getNumOfAccounts() {
		return accounts.size();
	}

	public void addAccount(Account account) {
		this.accounts.add(account);
	}

	public Optional<Account> getAccount(String iban) {
		for (Account acc : accounts)
			if (acc.getIban().equals(iban))
				return Optional.of(acc);
		return Optional.empty();
	}

	public double getBalance() {
		double sum = 0.0;
		for (Account acc : accounts)
			sum += acc.getBalance();
		return sum;
	}

	public double getBalance8() {
		return accounts.stream().mapToDouble(Account::getBalance).sum();
	}

	public List<Account> getAccounts() {
//		return new ArrayList<>(accounts);
		return Collections.unmodifiableList(accounts);
	}
}
