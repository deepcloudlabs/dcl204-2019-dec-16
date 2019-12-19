package com.example.lottery.app;

import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class SimpleLotteryApp {

	public static void main(String[] args) {
		ThreadLocalRandom.current()
		                 .ints(1,50)
		                 .distinct()
		                 .limit(6)
		                 .sorted()
		                 .boxed()
		                 .collect(Collectors.toList());

	}

}
