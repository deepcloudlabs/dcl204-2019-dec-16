package com.example;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;

/**
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class StudyDateFormat {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		ZonedDateTime now = ZonedDateTime.now();
		Locale tr = new Locale("tr");
		DateTimeFormatter dtf = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.FULL).withLocale(Locale.KOREA);
		System.out.println(dtf.format(now));
	}

}
