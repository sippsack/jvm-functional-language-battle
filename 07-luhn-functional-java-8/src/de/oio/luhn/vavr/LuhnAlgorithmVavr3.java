package de.oio.luhn.vavr;

import java.util.function.Function;

import io.vavr.collection.CharSeq;
import io.vavr.collection.Seq;


public class LuhnAlgorithmVavr3 {
	
	static Function<? extends Number, Seq<Integer>> numberToDigits = number -> CharSeq.of(number.toString())
			.map(c -> c - '0');
	
	static Function<Seq<Integer>, Seq<Integer>> reverse = Seq::reverse;

	static Function<Seq<Integer>, Seq<Integer>> double2nd = digits -> digits.zipWithIndex()
			.map(t -> t._1 * (t._2 % 2 + 1));

//	static Function<Seq<Integer>, Integer> sumDigits = digits -> digits.flatMap(numberToDigits).sum().intValue();
//
//	static Function<Integer, Boolean> divisibleBy10 = number -> number % 10 == 0;
//	
//	static Function<? extends Number, Boolean> isValid = numberToDigits
//			.andThen(reverse)
//			.andThen(double2nd)
//			.andThen(sumDigits)
//			.andThen(divisibleBy10);
}



