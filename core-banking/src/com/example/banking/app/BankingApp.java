package com.example.banking.app;

import com.example.banking.entity.Account;
import com.example.banking.entity.Customer;

public class BankingApp {
	public static void main(String[] args) {
		Customer jack = new Customer("1", "Jack Bauer");
		jack.addAccount(new Account("TR1", 1_000));
		jack.addAccount(new Account("TR2", 2_000));
		jack.addAccount(new Account("TR3", 3_000));
		jack.getAccount("TR2").ifPresent(acc -> acc.deposit(3_000));
		System.out.println("Total balance: " + jack.getBalance());
//		jack.getAccount("TR4").get().deposit(3_000);
//		jack.getAccounts().add(new Account("TR4",4000));
	}
}
