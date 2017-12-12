package de.oio.luhn.thomas_much;

import java.util.PrimitiveIterator;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class Luhn {
	private static Function<String, String> reverse = number -> new StringBuilder(number).reverse().toString();

	public static boolean isValid(String number) {
		PrimitiveIterator.OfInt faktor = IntStream.iterate(1, i -> 3 - i).iterator();
		return new StringBuilder(number)
				.reverse()
				.chars()
				.map(c -> faktor.nextInt() * (c - '0'))
				.reduce(0, (a, b) -> a + b / 10 + b % 10) 
				% 10 == 0;
	}

	public static boolean isValid(long number) {
		PrimitiveIterator.OfInt faktor = IntStream.iterate(1, i -> 3 - i).iterator();
		return LongStream.iterate(number, n -> n / 10)
				.takeWhile(n -> n > 0)
				.map(n -> n % 10)
				.map(n -> n * faktor.nextInt())
				.map(n -> n > 9 ? n - 9 : n).sum()
				% 10 == 0;
	}

	public static void main(String[] args) {
		System.out.println(reverse.apply("1234567"));
		System.out.println(isValid("23456"));
		System.out.println(isValid(23456L));
		System.out.println(isValid("234567"));
		System.out.println(isValid(234567L));
		System.out.println(isValid("4012888888881881"));
		System.out.println(isValid(4012888888881881L));
		PrimitiveIterator.OfInt faktor = IntStream.iterate(1, i -> 3 - i).iterator();
		System.out.println(faktor.nextInt());
		System.out.println(faktor.nextInt());
		System.out.println(faktor.nextInt());
		System.out.println(faktor.nextInt());
	}
}
