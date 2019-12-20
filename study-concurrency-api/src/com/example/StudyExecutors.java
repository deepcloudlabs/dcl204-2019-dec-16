package com.example;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyExecutors {

	public static void main(String[] args) throws InterruptedException, ExecutionException {
		ExecutorService es = Executors.newFixedThreadPool(10);
		LotteryCallableTask task = 
				new LotteryCallableTask(1, 50, 6);		
		Future<List<Integer>> future =
				    es.submit(task);
		System.out.println(future.get());
		es.shutdown();
	}

}
