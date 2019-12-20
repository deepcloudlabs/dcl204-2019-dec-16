package com.example;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyFundamentals {

	@SuppressWarnings("unused")
	public static void main(String[] args) throws IOException {
		int x = 3615; // 4-byte
		// 1. Text IO ==> char[]
		// x ==> 42 (2 byte)
		// x ==> 3615 (4 byte)
		// 2. Binary IO ==> byte[]
		// x ==> 4B

		int numbers[] = { 4, 8, 15, 16, 23, 42 };
		// Text IO: 4,8,15,16,23,42: 10B
		// Binary IO: 24B
		long counter = Files.readAllLines(Paths.get("c:/tmp", "flags8.txt")).stream()
				.filter(line -> line.startsWith("     bool")).count();
		System.out.println(counter);
	}

}
