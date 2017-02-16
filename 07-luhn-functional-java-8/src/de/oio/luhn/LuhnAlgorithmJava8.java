package de.oio.luhn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class LuhnAlgorithmJava8 {

	static Function<Long, List<Long>> toDigits = 
			number -> number <= 0 ? Collections.emptyList() : Stream.concat(LuhnAlgorithmJava8.toDigits.apply(number / 10).stream(), Stream.of(number % 10)).collect(Collectors.toList());
	
	static List<Long> toDigits2(Long number) {
		return number <= 0 ? Collections.emptyList() : Stream.concat(toDigits2(number / 10).stream(), Stream.of(number % 10)).collect(Collectors.toList());
	}
	
	static Function<List<Long>, List<Long>> reverse = list -> {
		List<Long> result = new ArrayList<>(list);
		Collections.reverse(result);
		return result;
	};

	static Function<List<Long>, List<Long>> double2nd = digits -> {
		Ref<Boolean> even = new Ref<>(false);
		return digits.stream().map(digit -> {Long result = digit * (even.get() ? 2 : 1); even.set(!even.get()); return result;}).collect(Collectors.toList());
	};
	
	static Function<List<Long>, Long> sumDigits = list ->
		list.stream().reduce(0L, (acc, l) -> acc + toDigits.apply(l).stream().reduce(0L, (acc2, l2) -> acc2 + l2));

	static Function<Long, Boolean> divisibleBy10 = number -> 0 == number % 10;
		
	static Function<Long, Boolean> isValid = number -> divisibleBy10.compose(sumDigits).compose(double2nd).compose(reverse).compose(toDigits).apply(number);

	static boolean isValid(Long number) {
		return divisibleBy10.apply(sumDigits.apply(double2nd.apply(reverse.apply(toDigits.apply(number)))));
	}

	static boolean isValid2(Long number) {
		return divisibleBy10.compose(sumDigits).compose(double2nd).compose(reverse).compose(toDigits).apply(number);
	}

	public static void main(String[] args) {
		System.out.println(toDigits.apply(1234L));
		System.out.println(reverse.apply(toDigits2(1234L)));
		
		System.out.println(isValid(23456L));
		System.out.println(isValid(234567L));
		System.out.println(isValid2(23456L));
		System.out.println(isValid2(234567L));
		System.out.println(isValid.apply(4012888888881881L));
		System.out.println(isValid(4012888888881881L));
	}

	static class Ref<T> {
		private T value;

		Ref(T value) {
			this.value = value;
		}
		
		T get() {
			return this.value;
		}
		
		void set(T value) {
			this.value = value;
		}
	}
}
