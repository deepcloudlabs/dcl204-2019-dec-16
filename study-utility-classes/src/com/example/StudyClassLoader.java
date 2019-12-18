package com.example;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyClassLoader {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		Class<?> clazz1 = int.class;
		Class<?> clazz2 = void.class;
		Class<?> clazz4 = int[][].class;
		Class<?> clazz3 = A.class;
		for (Field field : A.class.getDeclaredFields()) {
			System.out.println(field.getName());
		}
		for (Constructor<?> constructor : A.class.getDeclaredConstructors()) {
			System.out.println(constructor.getName() + " : " + constructor.getParameterCount());
		}
	}
}

@SuppressWarnings("unused")
class A {
	private int i;
	private double j;
	private boolean k;

	public A(int i, double j, boolean k) {
		this.i = i;
		this.j = j;
		this.k = k;
	}

	public A() {
	}

	public A(int i, double j) {
		this.i = i;
		this.j = j;
	}

}
