package com.example.banking.entity;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@SuppressWarnings("serial")
public final class Customer implements Serializable {
	private final String identity;
	private String fullname;
	private final Map<String, Account> accounts;

	public Customer(final String identity, final String fullname) {
		this.identity = identity;
		this.fullname = fullname;
		this.accounts = new HashMap<>();
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
		String iban = account.getIban();
		this.accounts.put(iban, account);
	}

	public Optional<Account> getAccount(String iban) {
		return Optional.ofNullable(accounts.get(iban));
	}

	public double getBalance() {
		double sum = 0.0;
		for (Account acc : accounts.values())
			sum += acc.getBalance();
		return sum;
	}

	public double getBalance8() {
		return accounts.values().stream().mapToDouble(Account::getBalance).sum();
	}

	public Collection<Account> getAccounts() {
		return accounts.values();
	}

	@Override
	public String toString() {
		return "Customer [identity=" + identity + ", fullname=" + fullname + ", balance= " + getBalance()
				+ ", numOfAccounts= " + accounts.size() + "]";
	}

}
