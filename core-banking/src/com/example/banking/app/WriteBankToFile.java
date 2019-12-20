package com.example.banking.app;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

import com.example.banking.entity.Account;
import com.example.banking.entity.Bank;
import com.example.banking.entity.Customer;
import com.example.banking.entity.InsufficientBalanceException;

public class WriteBankToFile {
	public static void main(String[] args) throws InsufficientBalanceException {
		Bank garanti = new Bank(1, "Garanti Bankası A.Ş.");
		Customer jack = garanti.createCustomer("1", "Jack Bauer");
		jack.addAccount(new Account("TR1", 10_000));
		jack.addAccount(new Account("TR2", 20_000));
		jack.addAccount(new Account("TR3", 30_000));
		Customer kate = garanti.createCustomer("2", "Kate Austen");
		kate.addAccount(new Account("TR4", 100_000));
		kate.addAccount(new Account("TR5", 200_000));
		Customer james = garanti.createCustomer("3", "James Sawyer");
		james.addAccount(new Account("TR6", 2_000));
		File tmp = new File("c:/tmp");
		try (FileOutputStream fos = new FileOutputStream(new File(tmp, "garan.bak"));
				ObjectOutputStream oos = new ObjectOutputStream(fos);) {
			oos.writeObject(garanti);
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Bank is saved to the file!");
	}
}
