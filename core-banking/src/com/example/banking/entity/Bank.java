package com.example.banking.entity;

import java.io.Serializable;
import java.text.MessageFormat;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.function.Consumer;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
@SuppressWarnings("serial")
public class Bank implements TransferService, Serializable {
	private final int id;
	private final String name;
	private Map<String, Customer> customers;
	@SuppressWarnings("unused")
	transient private String password= "s3c-r3t";
	
	public Bank(int id, String name) {
		this.id = id;
		this.name = name;
		customers = new HashMap<>();
	}

	public final int getId() {
		return id;
	}

	public final String getName() {
		return name;
	}

	public final Collection<Customer> getCustomers() {
		return customers.values();
	}

	public final Customer createCustomer(String identity, String fullname) {
		Customer customer = new Customer(identity, fullname);
		customers.put(identity, customer);
		return customer;
	}

	public Optional<Customer> findCustomerByIdentity(String identity) {
		return Optional.ofNullable(customers.get(identity));
	}

	public double getBalance() {
		double totalBalance = 0;
		for (Customer customer : customers.values()) {
			totalBalance += customer.getBalance();
		}
		return totalBalance;
	}

	public Optional<Account> getAccount8(String iban) {
		return customers.values().stream().map(Customer::getAccounts).flatMap(Collection::stream)
				.filter(account -> account.getIban().equals(iban)).findFirst();
	}

	public Optional<Account> getAccount9(String iban) {
		return customers.values().stream().map(cust -> cust.getAccount(iban)).filter(Optional::isPresent)
				.map(Optional::get).findFirst();
	}

	public Account getAccount(String iban) {
		for (Customer customer : customers.values()) {
			Optional<Account> account = customer.getAccount(iban);
			if (account.isPresent())
				return account.get();
		}
		throw new AccountNotFoundException(iban, "Cannot find the account!");
	}

	public Account getAccountValue(String iban) {
		for (Customer customer : customers.values()) {
			Optional<Account> account = customer.getAccount(iban);
			if (account.isPresent())
				return account.get();
		}
		return null;
	}

	@Override
	public void transfer(String fromIban, String toIban, double amount) throws InsufficientBalanceException {
		if (amount <= 0)
			throw new IllegalArgumentException("Amount should be positive!");
		Account fromAccount = getAccount(fromIban);
		Account toAccount = getAccount(toIban);
		// "Transactional"
		try {
			// TODO: apply memento pattern
			fromAccount.withdraw(amount);
			toAccount.deposit(amount);
		} catch (Throwable e) {
			// TODO: restore the state back to the accounts
			throw e;
		}
	}

	public void transferValue(String fromIban, String toIban, double amount) throws InsufficientBalanceException {
		Account fromAccount = getAccountValue(fromIban);
		Account toAccount = getAccountValue(toIban);
		if (Objects.nonNull(fromAccount) && Objects.nonNull(toAccount)) {
			fromAccount.withdraw(amount);
			toAccount.deposit(amount);
		}
	}

	public void generateReport() {
		generateReport(Locale.US);
	}

	public void generateReport(Locale locale) {
		generateReport(locale, Comparator.comparing(Customer::getFullname), System.out::println);
	}

	public void generateReport(Locale locale, Comparator<Customer> orderBy, Consumer<Customer> printCustomer) {
		System.out.println("==========================================================================");
		ZonedDateTime now = ZonedDateTime.now();
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(locale);
		ResourceBundle bundle = ResourceBundle.getBundle("report", locale);
		MessageFormat formatter = new MessageFormat(bundle.getString("report.heading"), locale);
		System.out.println(formatter.format(new Object[] { dtf.format(now) }));
		customers.values().stream().sorted(orderBy).forEach(printCustomer);
		System.out.println("==========================================================================");
	}
}