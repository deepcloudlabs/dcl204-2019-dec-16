package com.example.lottery.model;

import java.util.List;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class LotteryViewModel {
	@RandomNumber(min=1,max=50,size=8,distinct=false,sorted=false)
	private List<Integer> numbers;

	public LotteryViewModel() {
	}

	public List<Integer> getNumbers() {
		return numbers;
	}
	
}
