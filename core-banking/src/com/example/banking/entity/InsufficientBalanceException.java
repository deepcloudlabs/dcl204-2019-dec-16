package com.example.banking.entity;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("serial")
public class InsufficientBalanceException extends Exception {

	private final double deficit;

	public InsufficientBalanceException(double deficit, String message) {
		super(message);
		this.deficit = deficit;
	}

	public double getDeficit() {
		return deficit;
	}

}
