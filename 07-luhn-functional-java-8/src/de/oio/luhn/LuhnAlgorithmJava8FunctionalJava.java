package de.oio.luhn;

import fj.data.List;
import fj.data.Stream;
import lombok.Value;

public class LuhnAlgorithmJava8FunctionalJava {
	
	@Value
	private static class ImmutablePerson {
		private String name;
	}
	
	public static void main(String[] args) {
		System.out.println(new ImmutablePerson("Duke").getName());
		System.out.println(new ImmutablePerson("Duke").equals(new ImmutablePerson("Duke")));
		System.out.println(new ImmutablePerson("Duke") == new ImmutablePerson("Duke"));

		System.out.println(doubleSecond(List.list(1L, 2L, 3L, 4L)));
		System.out.println(sumDigits(List.list(1L, 12L, 3L, 4L)));
		System.out.println(isValid(4716347184862961L));
	}
	
	public static List<Long> toDigits(long l) {
		return l <= 0 ? List.nil() : toDigits(l / 10).append(List.list(l % 10));
	}

	public static List<Long> toDigitsReverse(long l) {
		return toDigits(l).reverse();
	}

	public static List<Long> doubleSecond(List<Long> list) {
		return list.toStream().zipWith(Stream.cycle(List.list(1, 2).toStream()), (_1, _2) -> _1 * _2).toList();
	}

	public static long sumDigits(List<Long> list) {
		return list.foldLeft((acc, l) -> acc + toDigits(l).foldLeft((acc2, l2) -> acc2 + l2, 0L), 0L);
	}

	public static boolean isValid(long l) {
		return sumDigits(doubleSecond(toDigitsReverse(l))) % 10 == 0;
	}
}

