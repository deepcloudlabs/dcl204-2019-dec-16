package com.example;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyPolymorphism {
	@SuppressWarnings("unused")
	public static void main(String[] args) {
		A a = new B();
		C c = (C) a; // Runtime: ClassCastException
	}
}

class A {
	public void fun() {
		System.out.println("A::fun()");
	}
}

class B extends A {
	public void fun() {
		System.out.println("B::fun()");
	}
}

class C extends B {
	public void fun() {
		System.out.println("C::fun()");
	}
}