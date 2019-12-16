package com.example.banking.entity;

public class Account extends Object {
	// attribute, field, state
	private final String iban;
	private double balance;
	public Account(String iban, double balance) {
		this.iban = iban;
		this.balance = balance;
	}
	public String getIban() {
		return iban;
	}
	public double getBalance() {
		return balance;
	}
	public boolean deposit(double amount) {
		// validation
		if (amount<=0) return false;
		// business logic
		balance += amount ;
		return true;
	}
	public boolean withdraw(double amount) {
		// validation
		if (amount<=0) return false;
		// business rule		
		if (amount>balance) return false;
		// business logic
		balance -= amount;
		return true;
	}
	@Override
	public String toString() {
		return "Account [iban=" + iban + ", balance=" + balance + "]";
	}
	
}





