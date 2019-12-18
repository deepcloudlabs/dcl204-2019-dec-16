package com.example.banking.app;

import java.util.Locale;

import com.example.banking.entity.Account;
import com.example.banking.entity.Bank;
import com.example.banking.entity.Customer;

public class BankingApp {
	public static void main(String[] args) {
		Bank garanti = new Bank(1,"Garanti Bankası A.Ş.");
		Customer jack = 
			garanti.createCustomer("1", "Jack Bauer");
		jack.addAccount(new Account("TR1", 1_000));
		jack.addAccount(new Account("TR2", 2_000));
		jack.addAccount(new Account("TR3", 3_000));
		Customer kate = 
				garanti.createCustomer("2", "Kate Austen");
		kate.addAccount(new Account("TR4", 100_000));
		kate.addAccount(new Account("TR5", 200_000));
		Customer james = 
				garanti.createCustomer("3", "James Sawyer");
		james.addAccount(new Account("TR6", 2_000));
		garanti.generateReport(Locale.ITALY);
	}
}
