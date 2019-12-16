package com.example;

import java.math.BigDecimal;

public class StudyFloatingPoint {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		float f = 3.1415161718F; // 4-byte
		double g = 3.141516; // 8-byte
		double x = (0.1 + 0.2) + 0.3;
		double y = 0.1 + (0.2 + 0.3);
		System.out.println(x == y);
		double z = 2.0;
		z = z - 1.10;
		System.out.println(String.format("%8.16f", z));
		float u = 1_000_000_000;
		u = u + 50;
		System.out.println(String.format("%16.3f", u));
		// Immutable Class
		BigDecimal bd = BigDecimal.valueOf(2.0);
		bd = bd.subtract(BigDecimal.valueOf(1.1));
		System.out.println(bd.toString());
		double one = 0 / 0.;
		System.out.println("one=" + one);
		System.out.println(Double.isNaN(one));
		Double a = null;
//		System.out.println(a == a);
		one = 1 / -0.;
		System.out.println("one=" + one);

	}

}
