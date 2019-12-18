package com.example;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyStringDeduplication {

	public static void main(String[] args) {
		// -XX:+PrintStringDeduplicationStatistics
		// -XX:+UseStringDeduplication
		String name1 = "Kate"; // static String
		String name2 = new String("Kate"); // Heap
		String name3 = "Kate";
		name2 = name2.intern();
		System.err.println("name1==name2: "+(name1==name2));
		System.err.println("name1==name3: "+(name1==name3));
	}

}
