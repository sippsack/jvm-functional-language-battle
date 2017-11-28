package de.oio.luhn

println(isValid(378282246310005)) // true
println(isValid(76009244561)) // false

def isValid(Long number) {
    number.toString()
        .reverse()
        .split('').toList()
        .indexed()
        .collect {i, c -> [i, Integer.parseInt(c)]}
        .collect {i, d -> i % 2 == 0 ? d : 2 * d}
        .collect {d -> d > 9 ? d - 9 : d}
        .sum() % 10 == 0
}
