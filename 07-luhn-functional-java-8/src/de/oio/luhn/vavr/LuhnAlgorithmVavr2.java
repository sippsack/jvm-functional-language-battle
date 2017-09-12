package de.oio.luhn.vavr;

import java.util.function.Function;
import io.vavr.collection.CharSeq;
import io.vavr.collection.Seq;

public class LuhnAlgorithmVavr2 {
	
	static Function<Long, Seq<Integer>> longToDigits = number -> CharSeq
			.of(Long.toString(number)).map(c -> c - '0');
	
	static Function<Seq<Integer>, Seq<Integer>> reverse = Seq::reverse;

	static Function<Seq<Integer>, Seq<Integer>> double2nd = digits -> digits
			.zipWithIndex().map(t -> t._1 * (t._2 % 2 + 1));

	static Function<Seq<Integer>, Integer> sumDigits = digits -> digits
			.map(i -> i.longValue()).flatMap(longToDigits).sum().intValue();

	static Function<Integer, Boolean> divisibleBy10 = number -> number % 10 == 0;
	
	static Function<Long, Boolean> isValid = longToDigits
			.andThen(reverse)
			.andThen(double2nd)
			.andThen(sumDigits)
			.andThen(divisibleBy10);

	
	public static void main(String[] args) {
		System.out.println(longToDigits.apply(1234L));
		System.out.println(reverse.apply(longToDigits.apply(1234L)));
		
		System.out.println(isValid.apply(23456L));
		System.out.println(isValid.apply(234567L));
		System.out.println(isValid.apply(4012888888881881L));
	}
}
