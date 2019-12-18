package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyList {

	public static void main(String[] args) {
		// List: Ordered, Allows duplicates
		List<Integer> numbers = new ArrayList<>(30_000_000);
		numbers.add(4);
		numbers.add(42);
		numbers.add(16);
		numbers.add(23);
		numbers.add(8);
		numbers.add(3,15);
		numbers.add(42);
		numbers.add(8);
		System.out.println(numbers.contains(8));
		System.out.println(numbers.get(4));
		System.out.println(numbers);
		Comparator<Integer> orderByAsc = 
				Integer::compare;
		Comparator<Integer> orderByDesc = 
				orderByAsc.reversed();
		Collections.sort(numbers,orderByDesc);
		System.out.println(numbers);
		for(int number : numbers) {
			System.out.println(number);
		}
	}

}
