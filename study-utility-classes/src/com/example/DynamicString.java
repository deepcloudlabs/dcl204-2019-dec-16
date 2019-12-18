package com.example;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class DynamicString {

	public static void main(String[] args) {
		// StringBuffer is Thread Safety
		// StringBuilder is NOT Thread Safety
		StringBuffer s = new StringBuffer(188888890);
		long start = System.currentTimeMillis();
		for (int i=0;i<25_000_000;++i)
			s.append(i);
		long stop = System.currentTimeMillis();
		System.out.println(s.length()+" @ "+(stop-start)+" ms.");
	}

}
