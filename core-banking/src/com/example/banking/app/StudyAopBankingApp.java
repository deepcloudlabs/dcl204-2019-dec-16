package com.example.banking.app;

import java.lang.reflect.Proxy;

import com.example.banking.aop.AuditInvocationHandler;
import com.example.banking.entity.Account;
import com.example.banking.entity.Bank;
import com.example.banking.entity.Customer;
import com.example.banking.entity.InsufficientBalanceException;
import com.example.banking.entity.TransferService;

public class StudyAopBankingApp {
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
		Class<? extends Bank> clazz = garanti.getClass();
		TransferService transferService = (TransferService)
				Proxy.newProxyInstance(
						clazz.getClassLoader(), 
						clazz.getInterfaces(),
						new AuditInvocationHandler(garanti)
				);
		System.out.println(transferService.getClass());
		transferService.transfer("TR3", "TR6", 15_000);
		transferService.transfer("TR2", "TR4", 5_000);
		garanti.transfer("TR2", "TR4", 5_000);
	}
}
