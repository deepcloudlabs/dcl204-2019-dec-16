package com.example;

import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyRunnableThread {

	public static void main(String[] args) throws InterruptedException {
		LotteryTask task = new LotteryTask(1, 50, 6);
		Thread t = new Thread(task);
		t.start();
		t.join();
		System.out.println(task.getNumbers());
	}

}
// byte --> Byte (Wrapper Class) (Immutable)
// short --> Short
// int --> Integer
// long --> Long
// boolean --> Boolean
// char --> Character

class LotteryTask implements Runnable {
	private int min, max, size;
	private List<Integer> numbers;

	public LotteryTask(int min, int max, int size) {
		this.min = min;
		this.max = max;
		this.size = size;
	}

	public List<Integer> getNumbers() {
		return numbers;
	}

	@Override
	public void run() {
		numbers = ThreadLocalRandom.current().ints(min, max).distinct().limit(size).sorted().boxed()
				.collect(Collectors.toList());
	}

}