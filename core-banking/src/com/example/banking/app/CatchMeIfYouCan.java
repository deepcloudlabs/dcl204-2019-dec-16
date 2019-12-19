package com.example.banking.app;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class CatchMeIfYouCan {
	@SuppressWarnings("finally")
	public static int haveFun() {
		try {
			System.out.println("At the try block now...");
//			return 42;
			System.exit(42);
		} finally {
			System.out.println("At the finally block now...");
			return 108;
		}
	}

	public static void main(String[] args) {
		System.out.println("Have fun value: "+ haveFun());

	}

}
