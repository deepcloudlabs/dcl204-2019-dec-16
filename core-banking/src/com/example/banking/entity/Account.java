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

	public void deposit(final double amount) {
		// validation
		if (amount <= 0)
			throw new IllegalArgumentException(
					"Amount should be positive!");
		// business logic
		balance += amount;
	}

	public void withdraw(final double amount) 
			      throws InsufficientBalanceException {
		// validation
		if (amount <= 0)
			throw new IllegalArgumentException(
					"Amount should be positive!");
		// business rule
		if (amount > balance)
			throw new InsufficientBalanceException(amount-balance,"Your balance does not cover your expenses!");
		// business logic
		balance -= amount;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}

}
