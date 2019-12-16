package com.example;

import java.math.BigInteger;

public class StudyIntegralTypes {

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		// signed
		byte b = 127; // 1-byte, [-128..127]
		System.out.println("b=" + b);
		b++;
		System.out.println("b=" + b);
		// 2-byte: [-32768..32767]
		short s = Short.MAX_VALUE;
		System.out.println("s=" + s);
		s++;
		System.out.println("s=" + s);
		// int : 4-byte, [-2147483648..2147483647]
		int i = Integer.MAX_VALUE;
		System.out.println("i=" + i);
		i++;
		System.out.println("i=" + i);
		// long : 8-byte: [-9223372036854775808..9223372036854775807]
		long l = Long.MAX_VALUE;
		System.out.println("l=" + l);
		l++;
		System.out.println("l=" + l);
		// BigInteger: Immutable Class
		BigInteger bi = BigInteger.valueOf(9223372036854775807L);
		System.out.println("bi=" + bi);
		bi = bi.add(BigInteger.ONE);
		System.out.println("bi=" + bi);
		long x = 0;
		x = 2147483647 + 1L;
		System.out.println("x=" + x);
		byte u = 3, v = 5, z = 0;
		z += u + v; // z = (byte)(z + u + v)
//		z = (byte) (u + v) ;
		long t = 12345 + 5432L;
		System.out.println("t=" + t);
		int one = 1 / 0;
		System.out.println("one=" + one);
	}

}
