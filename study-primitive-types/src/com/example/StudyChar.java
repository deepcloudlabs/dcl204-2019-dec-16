package com.example;

public class StudyChar {

	public static void main(String[] args) {
		char x = 'a'; // unicode
		System.out.println(x);
		System.out.println((char)(x+1));
		x = '\u20BA';
		System.out.println(x);
	}

}
