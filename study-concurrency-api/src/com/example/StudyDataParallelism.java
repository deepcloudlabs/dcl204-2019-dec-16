package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.IntStream;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyDataParallelism {
	private static List<Integer> numbers = new ArrayList<>();

	static {
		IntStream.range(0, 400_000).forEach(numbers::add);
	}

	public static void main(String[] args) {
		for (int i = 0; i < 10; ++i)
			runSerialSolver();
		for (int i = 0; i < 10; ++i)
			runParallelSolver();
		for (int i = 0; i < 10; ++i)
			runParallelStreamSolver();

	}

	private static void runParallelStreamSolver() {
		long start = System.nanoTime();
		long sum = numbers.parallelStream().mapToLong(Integer::intValue)
		     .sum();
		long stop = System.nanoTime();
		System.err.println(String.format("Parallel Stream: %16d %8d", sum, (stop - start)));
	}

	private static void runParallelSolver() {
		int cpus = Runtime.getRuntime().availableProcessors();
		ExecutorService es = Executors.newFixedThreadPool(cpus);
		long start = System.nanoTime();
		List<Future<Long>> futures = new ArrayList<>();
		int size = numbers.size() / cpus;
		for (int i = 0, k = 0; i < cpus; ++i, k += size) {
			futures.add(es.submit(new ParallelSolverTask(k, size, numbers)));
		}
		long sum = 0;
		for (Future<Long> partialSum : futures)
			try {
				sum += partialSum.get();
			} catch (InterruptedException | ExecutionException e) {
				System.out.println(e.getMessage());
			}

		long stop = System.nanoTime();
		System.err.println(String.format("Parallel: %16d %8d", sum, (stop - start)));
		es.shutdown();
	}

	private static void runSerialSolver() {
		long start = System.nanoTime();
		long sum = 0L;
		for (int num : numbers)
			sum += num;
		long stop = System.nanoTime();
		System.err.println(String.format("Serial: %16d %8d", sum, (stop - start)));
	}

}

class ParallelSolverTask implements Callable<Long> {
	private int start;
	private int size;
	private List<Integer> numbers;

	public ParallelSolverTask(int start, int size, List<Integer> numbers) {
		this.start = start;
		this.size = size;
		this.numbers = numbers;
	}

	@Override
	public Long call() throws Exception {
		long sum = 0L;
		for (int i = start, j = 0; j < size; i++, j++)
			sum += numbers.get(i);
		return sum;
	}

}