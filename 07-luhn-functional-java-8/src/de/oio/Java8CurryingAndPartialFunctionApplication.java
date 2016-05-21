package de.oio;

import java.util.function.Function;
import java.util.function.IntBinaryOperator;
import java.util.function.IntFunction;
import java.util.function.IntUnaryOperator;

public class Java8CurryingAndPartialFunctionApplication {
	public static void main(String[] args) {
		IntBinaryOperator simpleAdd = (a, b) -> a + b;
		IntFunction<IntUnaryOperator> curriedAdd = a -> b -> a + b;

		System.out.println(simpleAdd.applyAsInt(4, 5));

		System.out.println(curriedAdd.apply(4).applyAsInt(5));

		IntUnaryOperator adder5 = curriedAdd.apply(5);
		System.out.println(adder5.applyAsInt(4));
		System.out.println(adder5.applyAsInt(6));

		Function<Integer, Integer> times2 = e -> e * 2;
		Function<Integer, Integer> squared = e -> e * e;

		System.out.println(times2.compose(squared).apply(4)); // 32
		System.out.println(times2.andThen(squared).apply(4)); // 64
	}
}
