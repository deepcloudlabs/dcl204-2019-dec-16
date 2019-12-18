package com.example.banking.app;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
import static com.example.banking.entity.Account.getCounter;

import com.example.banking.entity.Account;

public class StudyStatic {

	@SuppressWarnings("static-access")
	public static void main(String[] args) {
		System.out.println(getCounter());
		Account acc1 = new Account("TR1", 1_000);
		System.out.println(acc1.getCounter());
		Account acc2 = null;
		System.out.println(acc2.getCounter());
		// acc2.withdraw(100);
	}

}
