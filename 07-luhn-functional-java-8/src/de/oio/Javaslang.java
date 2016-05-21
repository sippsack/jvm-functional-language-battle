package de.oio;

import javaslang.Function1;
import javaslang.Function2;
import javaslang.Tuple;
import javaslang.Tuple2;
import javaslang.control.Option;

public class Javaslang {
	public static void main(String[] args) {
		Tuple2<String, Integer> java8 = Tuple.of("Java", 8); 

		System.out.println(java8._1); 
		System.out.println(java8._2);
		
		System.out.println(java8.transform((s, i) -> s + "slang " + i / 4));
		
		Function2<Integer, Integer, Integer> sum = (a, b) -> a + b;
		System.out.println(sum.apply(1, 2));
		System.out.println(sum.apply(5).apply(10));
		
		Function1<Integer, Integer> plusOne = a -> a + 1;
		Function1<Integer, Integer> multiplyByTwo = a -> a * 2;

		Function1<Integer, Integer> add1AndMultiplyBy2 = plusOne.andThen(multiplyByTwo);
		Function1<Integer, Integer> multiplyBy2AndAdd1 = plusOne.compose(multiplyByTwo);

		System.out.println(add1AndMultiplyBy2.apply(2));
		System.out.println(multiplyBy2AndAdd1.apply(2));
	
		Function2<Integer, Integer, Integer> divide = (a, b) -> a / b;

		Function2<Integer, Integer, Option<Integer>> safeDivide = Function2.lift(divide);

		System.out.println(safeDivide.apply(1, 0)); 
		System.out.println(safeDivide.apply(4, 2)); 

		Function1<Integer, Integer> add2 = sum.curried().apply(2);
		Function1<Integer, Integer> add3 = sum.apply(2);
		System.out.println(add2);
		System.out.println(add3);
		System.out.println(add2.apply(4));	
		System.out.println(add3.apply(4));	
	}
}