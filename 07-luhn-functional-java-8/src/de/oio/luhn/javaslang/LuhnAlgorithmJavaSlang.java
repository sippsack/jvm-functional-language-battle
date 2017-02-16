package de.oio.luhn.javaslang;

import javaslang.Function1;
import javaslang.collection.List;
import javaslang.collection.Stream;

public class LuhnAlgorithmJavaSlang {
	
	static Function1<Long, List<Long>> toDigits = 
			number -> number <= 0 
						? List.empty() 
						: LuhnAlgorithmJavaSlang.toDigits.apply(number / 10).appendAll(List.of(number % 10));
	
	static Function1<List<Long>, List<Long>> reverse = digits -> digits.reverse(); 
	
	static Function1<List<Long>, List<Long>> double2nd = 
			digits -> digits.zip(Stream.of(1, 2).cycle()).map(tuple -> tuple._1 * tuple._2);

	static Function1<List<Long>, Number> sumDigits = list -> list.flatMap(toDigits).sum();

	static Function1<Number, Boolean> divisibleBy10 = number -> 0 == number.longValue() % 10;
	
	static Function1<Long, Boolean> isValid = 
			number -> divisibleBy10.compose(sumDigits).compose(double2nd).compose(reverse).compose(toDigits).apply(number);
	
	static Function1<Long, Boolean> isValid2 = number -> divisibleBy10.compose(sumDigits).compose(double2nd).apply(toDigits.apply(number).reverse());
	static boolean isValid3(Long number) { 
		return divisibleBy10.apply(sumDigits.apply(double2nd.apply(toDigits.apply(number).reverse())));
	}
	
	public static void main(String[] args) {
		System.out.println(toDigits.apply(1234L));
		System.out.println(reverse.apply(toDigits.apply(1234L)));
		
		System.out.println(isValid.apply(23456L));
		System.out.println(isValid.apply(234567L));
		System.out.println(isValid2.apply(23456L));
		System.out.println(isValid2.apply(234567L));
		System.out.println(isValid.apply(4012888888881881L));
		System.out.println(isValid3(4012888888881881L));
	}
}
