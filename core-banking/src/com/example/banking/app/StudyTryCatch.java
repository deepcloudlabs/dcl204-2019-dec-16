package com.example.banking.app;

import com.example.banking.entity.Account;
import com.example.banking.entity.InsufficientBalanceException;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyTryCatch {

	public static void main(String[] args) throws InsufficientBalanceException {
		Account acc = new Account("TR1",10_000);
		
		try {
			acc.withdraw(50_000);
		} catch (InsufficientBalanceException | 
				   IllegalArgumentException e) {
			// multi catch (Java SE 7+)
			System.out.println(e.getMessage());
			//re-throw
			throw e;
		} finally {
			System.out.println("Finally we have arrived here!");
		}

	}

}
