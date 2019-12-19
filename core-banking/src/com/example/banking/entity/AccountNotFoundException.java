package com.example.banking.entity;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("serial")
public class AccountNotFoundException extends RuntimeException {

	private final String iban;

	public AccountNotFoundException(String iban, String message) {
		super(message);
		this.iban = iban;
	}

	public String getIban() {
		return iban;
	}

}
