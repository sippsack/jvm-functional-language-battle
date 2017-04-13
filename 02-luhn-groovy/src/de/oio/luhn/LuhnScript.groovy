package de.oio.luhn

class LuhnAlgorithm {
	public static boolean isValid(String number) {
		int total = 0
		number.reverse()
			  .eachWithIndex {ch, i ->
				  int digit = Integer.parseInt(ch)
				  total += i % 2 ? [0, 2, 4, 6, 8, 1, 3, 5, 7, 9][digit] : digit
			  }
		return !(total % 10)
	}

	public static boolean isValid2(String number) {
		number.reverse()
			.split('')
			.collect {Integer.parseInt(it)}
			.withIndex()
			.inject(0) {acc, it ->
				acc += it.last() % 2
						? [0, 2, 4, 6, 8, 1, 3, 5, 7, 9][it.first()]
						: it.first()
			} % 10 == 0
	}
}

println LuhnAlgorithm.isValid2("378282246310005")
