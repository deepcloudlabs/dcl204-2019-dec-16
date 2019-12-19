package com.example.banking.entity;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class CheckingAccount extends Account {
	private double overdraftAmount;

	public CheckingAccount(String iban, double balance, double overdraftAmount) {
		super(iban, balance);
		this.overdraftAmount = overdraftAmount;
	}

	public double getOverdraftAmount() {
		return overdraftAmount;
	}

	@Override
	public void withdraw(double amount) throws InsufficientBalanceException {
		if (amount<=0) 
			throw new IllegalArgumentException(
					"Amount should be positive!");
		if (amount > (balance+overdraftAmount))
			throw new InsufficientBalanceException(amount-balance-overdraftAmount,"Your balance does not cover your expenses!");
		balance -= amount;
	}
	
}
