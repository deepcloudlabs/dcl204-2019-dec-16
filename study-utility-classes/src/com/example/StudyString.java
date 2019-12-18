package com.example;

import java.util.Locale;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyString {

	public static void main(String[] args) {
		Locale tr = new Locale("tr","TR");
		String city = "izmir";
		String upperCity = city.toUpperCase(tr);
		System.out.println(upperCity);

	}

}
