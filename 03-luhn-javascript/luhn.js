console.log(isValid(378282246310005)) // true
console.log(isValid(76009244561)) // false

function isValid(number) {
    let even = false
    return number.toString()
        .split('')
        .reverse()
        .map(c => parseInt(c))
        .map(d => (even = !even) ? d : d < 5 ? d * 2 : (d - 5) * 2 + 1)
        .reduce((a, b) => a + b, 0)
        % 10 === 0
}

