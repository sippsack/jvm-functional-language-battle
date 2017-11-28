package de.oio.luhn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PrimitiveIterator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class LuhnAlgorithmJava8 {

	static Function<Long, List<Long>> toDigits = 
			number -> number <= 0 
						? Collections.emptyList() 
						: Stream.concat(LuhnAlgorithmJava8.toDigits.apply(number / 10).stream(), Stream.of(number % 10)).collect(Collectors.toList());
	
	static List<Long> toDigits2(Long number) {
		return number <= 0 ? Collections.emptyList() : Stream.concat(toDigits2(number / 10).stream(), Stream.of(number % 10)).collect(Collectors.toList());
	}
	
	static Function<List<Long>, List<Long>> reverse = list -> {
		List<Long> result = new ArrayList<>(list);
		Collections.reverse(result);
		return result;
	};

	static Function<List<Long>, List<Long>> double2nd = digits -> {
		PrimitiveIterator.OfInt faktor = IntStream.iterate(1, i -> 3 - i).iterator();
		return digits.stream().map(digit -> digit * faktor.nextInt()).collect(Collectors.toList());
	};
	
	static Function<List<Long>, Long> sumDigits = list ->
		list.stream().reduce(0L, (acc, l) -> acc + toDigits.apply(l).stream().reduce(0L, (acc2, l2) -> acc2 + l2));

	static Function<Long, Boolean> divisibleBy10 = number -> 0 == number % 10;
		
	static Function<Long, Boolean> isValid = number -> divisibleBy10.compose(sumDigits)
			.compose(double2nd).compose(reverse).compose(toDigits).apply(number);
}


