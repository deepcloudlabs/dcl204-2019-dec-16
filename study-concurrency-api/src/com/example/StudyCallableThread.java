package com.example;

import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.stream.Collectors;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyCallableThread {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		LotteryCallableTask task = new LotteryCallableTask(1, 50, 6);
		FutureTask<List<Integer>> future = 
				new FutureTask<>(task);
		Thread t = new Thread(future);
		t.start();
		while(true) {
			try {
				System.err.println(future.get(10,
						TimeUnit.MILLISECONDS));
				break;
			} catch (TimeoutException e) {
                System.err.println("I am doing another task...");
			}			
		}
	}

}

class LotteryCallableTask implements Callable<List<Integer>> {
	private int min, max, size;

	public LotteryCallableTask(int min, int max, int size) {
		this.min = min;
		this.max = max;
		this.size = size;
	}

	@Override
	public List<Integer> call() {
		return ThreadLocalRandom.current().ints(min, max).distinct().limit(size).sorted().boxed()
				.collect(Collectors.toList());
	}

}