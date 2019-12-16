package com.example;

import java.util.Arrays;

public class StudyIntegerArray {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		int numbers[] = { 4, 8, 15, 16, 23, 42 };
		int arr[] = new int[10];
		for (int i = 0; i <= arr.length; ++i)
			arr[i] = i;
//		System.out.println(Arrays.toString(arr));
		for (int x : arr) // SE 5: RO + Sequential
			System.out.println(x);
		// Java SE 8: Stream API
		Arrays.stream(arr).forEach(n -> System.out.println(n));
//			  .forEach(System.out::println);
	}

}
