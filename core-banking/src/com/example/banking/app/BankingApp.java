package com.example.banking.app;

import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.Locale;
import java.util.function.Consumer;

import com.example.banking.entity.Account;
import com.example.banking.entity.Bank;
import com.example.banking.entity.Customer;

public class BankingApp {
	private static final Locale tr = new Locale("tr", "TR");
	private static DecimalFormat df = (DecimalFormat) DecimalFormat.getCurrencyInstance(tr);
	private static final Consumer<Customer> printCustomerDetails = customer -> System.out.println(
			String.format("%8s %16s %11s %2d %16s", customer.getClass().getSimpleName(), customer.getFullname(),
					customer.getIdentity(), customer.getNumOfAccounts(), df.format(customer.getBalance())));

	public static void main(String[] args) {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		jack.addAccount(new Account("TR1", 1_000));
		jack.addAccount(new Account("TR2", 2_000));
		jack.addAccount(new Account("TR3", 3_000));
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		kate.addAccount(new Account("TR4", 100_000));
		kate.addAccount(new Account("TR5", 200_000));
		Customer james = garanti.createCustomer("3", "James Sawyer");
		james.addAccount(new Account("TR6", 2_000));
		df = (DecimalFormat) DecimalFormat.getCurrencyInstance(tr);
		garanti.generateReport(tr, Comparator.comparing(Customer::getBalance), printCustomerDetails);
		df = (DecimalFormat) DecimalFormat.getCurrencyInstance(Locale.US);
		garanti.generateReport(Locale.US, Comparator.comparing(Customer::getFullname), printCustomerDetails);
		df = (DecimalFormat) DecimalFormat.getCurrencyInstance(tr);
		garanti.generateReport(tr, Comparator.comparing(Customer::getBalance), printCustomerDetails);
	}
}
