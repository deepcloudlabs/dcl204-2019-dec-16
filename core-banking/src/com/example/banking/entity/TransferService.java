package com.example.banking.entity;

import com.example.banking.aop.Audit;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public interface TransferService {
	@Audit
	void transfer(String fromIban, String toIban, double amount) throws InsufficientBalanceException;

}