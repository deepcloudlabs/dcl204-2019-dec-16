package com.example.banking.app;

import java.math.BigInteger;
import java.util.concurrent.ThreadLocalRandom;

import com.example.banking.entity.Account;
import com.example.banking.entity.CheckingAccount;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyPolymorphism {

	public static void main(String[] args) {
		Object o = 42;
		o = "Jack";
		o = false;
		o = BigInteger.valueOf(1_000_000L);
		o = new Account("TR3",3_000);
		Account acc ;
		ThreadLocalRandom random = 
				ThreadLocalRandom.current();
		if (random.nextBoolean())
			acc = new Account("TR1",1_000);
		else
			acc = new CheckingAccount("TR2", 
					1_500, 500);
		System.out.println(acc.getClass());
		acc.withdraw(1); // which withdraw?
	}

}
