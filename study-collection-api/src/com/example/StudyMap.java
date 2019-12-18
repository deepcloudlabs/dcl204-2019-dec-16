package com.example;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyMap {

	public static void main(String[] args) {
		Map<String, Integer> areaCodes = new HashMap<>();
		areaCodes.put("istanbul-anadolu", 216);
		areaCodes.put("istanbul-avrupa", 212);
		areaCodes.put("ankara", 312);
		System.out.println(areaCodes.get("ankara"));
		// Loop on keys
		for (String city : areaCodes.keySet()) {
			System.out.println(city);
		}
		for (var city : areaCodes.keySet()) {
			System.out.println(city);
		}
		// Loop on values
		for (int code : areaCodes.values()) {
			System.out.println(code);
		}
		for (var code : areaCodes.values()) {
			System.out.println(code);
		}
		// Loop on entries
		for (var entry : areaCodes.entrySet()) {
			System.out.println(
				String.format("%16s : %3d",
							entry.getKey(),
							entry.getValue() )
			);		
		}
	}

}
