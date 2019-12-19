package com.example.lottery.app;

import com.example.lottery.model.LotteryViewModel;
import com.example.lottery.service.RandomNumberGenerator;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class LotteryApp {

	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException {
		LotteryViewModel lottery = new LotteryViewModel();
		RandomNumberGenerator.generate(lottery);
		System.out.println(lottery.getNumbers());
	}

}
