package com.example.banking.aop;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class AuditInvocationHandler implements InvocationHandler {
	private Object target;
	private double bddkTransferLimit;

	public AuditInvocationHandler(Object target) {
		this.target = target;
		Properties props = new Properties();
		try {
			props.load(new FileInputStream(new File("src", "application.properties")));
			bddkTransferLimit = Double.parseDouble(props.get("bddk.transfer.limit").toString());
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		if (method.isAnnotationPresent(Audit.class)) {
			Audit audit = method.getAnnotation(Audit.class);
			int fromIbanIndex = audit.fromIbanIndex();
			int toIbanIndex = audit.toIbanIndex();
			int amountIndex = audit.amountIndex();
			Object fromIban = args[fromIbanIndex];
			Object toIban = args[toIbanIndex];
			double amount = (double) args[amountIndex];
			if (amount >= bddkTransferLimit) {
				System.out.println(String.format("Transfering from %s to %s : %f", fromIban, toIban, amount));
			}
		}
		return method.invoke(target, args);
	}

}
