package com.example.banking.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class Bank {
	private final int id;
	private final String name;
	private List<Customer> customers;

	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
		customers = new ArrayList<>();
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public List<Customer> getCustomers() {
		return Collections.unmodifiableList(customers);
	}

	public Customer createCustomer(String identity,
			String fullname) {
		Customer customer = 
				new Customer(identity,fullname);
		customers.add(customer);
		return customer;
	}
	
	public Optional<Customer> findCustomerByIdentity(
			                    String identity){
		for (Customer customer : customers) {
			if (customer.getIdentity().equals(identity))
				return Optional.of(customer);
		}
		return Optional.empty();
	}
	
	public double getBalance() {
		double totalBalance=0;
		for (Customer customer: customers) {
			totalBalance += customer.getBalance();
		}
		return totalBalance;
	}
}
