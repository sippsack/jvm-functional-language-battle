package de.oio.luhn.javaslang;

import java.util.function.Function;

import javaslang.collection.CharSeq;
import javaslang.collection.IndexedSeq;
import javaslang.collection.Seq;

public class LuhnAlgorithmJavaSlang2 {
	
	static Function<Long, CharSeq> toDigits = number -> CharSeq.of(Long.toString(number));

	static Function<CharSeq, CharSeq> reverse = CharSeq::reverse;

	static Function<CharSeq, Seq<Long>> double2nd = digits -> digits.zipWithIndex().map(t -> (t._1 - '0') * (t._2 % 2 + 1));

	static Function<Seq<Long>, Long> sumDigits = digits -> digits.sum().longValue();

	static Function<Long, Boolean> divisibleBy10 = number -> number % 10 == 0;
	
	static Function<Long, Boolean> isValid = toDigits.andThen(reverse).andThen(double2nd).andThen(sumDigits).andThen(divisibleBy10);
	
	public static void main(String[] args) {
		System.out.println(toDigits.apply(1234L));
		System.out.println(reverse.apply(toDigits.apply(1234L)));
		System.out.println(CharSeq.of("1234").zipWithIndex());
		System.out.println(double2nd.apply(CharSeq.of("1234")));
		
		IndexedSeq<Integer> map = CharSeq.of("1234").map(c -> c - '0');
		System.out.println(map);
		
		System.out.println(isValid.apply(23456L));
		System.out.println(isValid.apply(234567L));
		System.out.println(isValid.apply(4012888888881881L));
	}
}
