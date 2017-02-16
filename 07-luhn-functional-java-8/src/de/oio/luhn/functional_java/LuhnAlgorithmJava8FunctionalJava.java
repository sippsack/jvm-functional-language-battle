package de.oio.luhn.functional_java;

import fj.F;
import fj.data.List;
import fj.data.Stream;

public class LuhnAlgorithmJava8FunctionalJava {
	
	public static List<Long> toDigits(Long number) {
		return number <= 0 ? List.nil() : toDigits(number / 10).append(List.list(number % 10));
	}

	public static F<List<Long>, List<Long>> reverse = list -> list.reverse();
	
	public static F<List<Long>, List<Long>> double2nd = 
			list -> list.toStream()
						.zipWith(Stream.cycle(List.list(1, 2).toStream()), (_1, _2) -> _1 * _2)
						.toList();
	
	public static F<List<Long>, Long> sumDigits = 
			list -> list.foldLeft((acc, l) -> acc + toDigits(l).foldLeft((acc2, l2) -> acc2 + l2, 0L), 0L);
	
	public static F<Long, Boolean> divisibleBy10 = number -> 0 == number % 10;

	public static F<Long, Boolean> isValid = 
			number -> divisibleBy10.f(sumDigits.f(double2nd.f(reverse.f(toDigits(number)))));
	
	public static Boolean isValid(Long number) {
		return isValid.f(number);
	}

	public static void main(String[] args) {
		System.out.println(sumDigits.f(List.list(1L, 12L, 3L, 4L)));
		System.out.println(isValid.f(4716347184862961L));
	}

}

