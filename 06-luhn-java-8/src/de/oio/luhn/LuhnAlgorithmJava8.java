package de.oio.luhn;

public class LuhnAlgorithmJava8 {
	public static boolean isValid(String creditCardNumber) {
		int[] i = { creditCardNumber.length() % 2 == 0 ? 1 : 2 }; // 1 if length even, 2 otherwise
		
		return creditCardNumber
				.chars()
				.map(in -> in - '0') // convert to the int equivalent
				.map(n -> n * (i[0] = i[0] == 1 ? 2 : 1)) // multiply by 1, 2 alternating
				.map(n -> n > 9 ? n - 9 : n) // handle sum of digits
				.sum() % 10 == 0; // mod 10 should be zero
	}

	public static void main(String[] args) {
		System.out.println(isValid("23456"));
		System.out.println(isValid("234567"));
		System.out.println(isValid("4012888888881881"));
	}
}

