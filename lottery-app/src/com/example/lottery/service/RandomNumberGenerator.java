package com.example.lottery.service;

import java.lang.reflect.Field;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.example.lottery.model.RandomNumber;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class RandomNumberGenerator {
	public static void generate(Object o) throws IllegalArgumentException, IllegalAccessException {
		Class<?> clazz = o.getClass();
		for (Field field : clazz.getDeclaredFields()) {
			if (field.isAnnotationPresent(RandomNumber.class)) {
				RandomNumber rn = field.getAnnotation(RandomNumber.class);

				field.setAccessible(true);
				field.set(o, createRandomList(rn));
				field.setAccessible(false);
			}
		}
	}

	private static List<Integer> createRandomList(RandomNumber rn) {
		int min = rn.min();
		int max = rn.max();
		int size = rn.size();
		boolean distinct = rn.distinct();
		boolean sorted = rn.sorted();
		IntStream stream = ThreadLocalRandom.current()
				   .ints(min, max);
		if (distinct)
			stream = stream.distinct();
		stream = stream.limit(size);
		if (sorted)
			stream = stream.sorted();     
		return stream.boxed().collect(Collectors.toList());
	}
}
