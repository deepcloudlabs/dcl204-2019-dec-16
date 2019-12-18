package com.example.banking.entity;

public class Account extends Object {
	private final String iban;
	protected double balance;
	private static int counter;
	private AccountStatus status;

	static { // static initializer
		counter = 0;
	}

	public Account(final String iban, final double balance) {
		this.iban = iban;
		this.balance = balance;
		counter++;
	}

	public AccountStatus getStatus() {
		return status;
	}

	public void setStatus(AccountStatus status) {
		this.status = status;
	}

	public static int getCounter() {
		return counter;
	}

	public String getIban() {
		return iban;
	}

	public double getBalance() {
		return balance;
	}

	public boolean deposit(final double amount) {
		// validation
		if (amount <= 0)
			return false;
		// business logic
		balance += amount;
		return true;
	}

	public boolean withdraw(final double amount) {
		System.out.println("Account::withdraw");
		// validation
		if (amount <= 0)
			return false;
		// business rule
		if (amount > balance)
			return false;
		// business logic
		balance -= amount;
		return true;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}
