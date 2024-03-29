package com.example.banking.app;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.entity.Account;
import com.example.banking.entity.CheckingAccount;
import com.example.banking.entity.InsufficientBalanceException;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyPolymorphism {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Object o = 42;
		o = "Jack";
		o = false;
		o = BigInteger.valueOf(1_000_000L);
		o = new Account("TR3", 3_000);
		Account acc;
		ThreadLocalRandom random = ThreadLocalRandom.current();
		if (random.nextBoolean())
			acc = new Account("TR1", 1_000);
		else
			acc = new CheckingAccount("TR2", 1_500, 500);
		System.out.println(acc.getClass());
		try {
			acc.withdraw(10_000);
		} catch (InsufficientBalanceException e) {
			System.out.println(e.getMessage());
			System.out.println("Deficit: "+e.getDeficit());
		} 
	}

}
