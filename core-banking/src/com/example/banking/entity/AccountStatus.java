package com.example.banking.entity;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public enum AccountStatus {
	ACTIVE(100), PASSIVE(200), CLOSED(300);
	private final int code;

	private AccountStatus(int code) {
		this.code = code;
	}

	public int getCode() {
		return code;
	}
	
}
