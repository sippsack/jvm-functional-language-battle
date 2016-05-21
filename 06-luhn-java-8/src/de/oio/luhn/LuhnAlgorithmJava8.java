package de.oio.luhn;

import java.util.ArrayList;
import java.util.List;

public class LuhnAlgorithmJava8 {
	public static boolean isValid(String creditCardNumber) {
		int[] i = { creditCardNumber.length() % 2 == 0 ? 1 : 2 }; // 1 if length even, 2 otherwise
		return creditCardNumber.chars().map(in -> in - '0') // convert to the int equivalent
			.map(n -> n * (i[0] = i[0] == 1 ? 2 : 1)) // multiply by 1, 2 alternating
			.map(n -> n > 9 ? n - 9 : n) // handle sum of digits
			.sum() % 10 == 0; // mod 10 should be zero
	}

	public static List<Long> toDigits(long l) {
		if (l <= 0) {
			return new ArrayList<Long>();
		}
		List<Long> digits = toDigits(l / 10);
		digits.add(l % 10);
		return digits;
	}

	public static List<Long> toDigitsReverse(long l) {
		// Implementierung wird schwierig
		return null;
	}

	public static List<Long> doubleSecond(List<Long> list) {
		// Implementierung wird schwierig
		return null;
	}

	public static long sumDigits(List<Long> list) {
		return list.stream().reduce(0L, (acc, l) -> acc + toDigits(l).stream().reduce(0L, (acc2, l2) -> acc2 + l2));
	}

	public static boolean isValid(long l) {
		return sumDigits(doubleSecond(toDigitsReverse(l))) % 10 == 0;
	}
}

