package com.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyRaceCondition {

	public static void main(String[] args) throws InterruptedException {
		CounterTask task = new CounterTask();
		List<Thread> threads = new ArrayList<>();
		IntStream.range(0, 8).forEach(i -> threads.add(new Thread(task)));
		long start = System.currentTimeMillis();
		threads.forEach(Thread::start);
		threads.forEach(t -> {
			try {
				t.join();
			} catch (InterruptedException e) {
			}
		});
		long stop = System.currentTimeMillis();
		System.out.println(task.getCounter() + " @ " + (stop - start) + " ms.");
	}

}

// Thread Safe
class CounterTask implements Runnable {
	private int counter;

	public int getCounter() {
		return counter;
	}

	@Override
	public void run() {
		for (int i = 0; i < 100_000; ++i) {
			synchronized (this) {
				counter++; // critical section, mutual exclusion
			}
		}
	}

}

class LockFreeCounterTask implements Runnable {
	private AtomicInteger counter = new AtomicInteger(0);

	public int getCounter() {
		return counter.get();
	}

	@Override
	public void run() {
		for (int i = 0; i < 100_000; ++i) {
			counter.getAndIncrement();
		}
	}

}