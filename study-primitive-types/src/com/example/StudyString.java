package com.example;

public class StudyString {

	public static void main(String[] args) {
		// static string, constant pool 
		String s = "Jack"; 
		String p = new String("Jack");
		String q = new String("Jack");
		String r = "Jack";
		System.out.println("s==r? "+(s==r));
		System.out.println("s==p? "+(s==p));
		System.out.println("p==q? "+(p==q));
		System.out.println("p.equals(q)? "+(p.equals(q)));
		System.out.println("2+2="+(2+2));
	}

}
