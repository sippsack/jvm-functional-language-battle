package de.oio.luhn

fun main(args: Array<String>) {
	println(isValid(378282246310005)) // true
	println(isValid(76009244561)) // false
}

fun isValid(number: Long): Boolean {
	var even = false
	return number.toString()
			.split("")
			.reversed()
			.filter { !it.isBlank() }
			.map { it.toInt() }
			.map { even = !even; if (even) it else it * 2 }
			.map { if (it > 9) it - 9 else it }
			.sum() % 10 == 0
}

