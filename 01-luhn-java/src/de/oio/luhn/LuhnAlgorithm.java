package de.oio.luhn;

public class LuhnAlgorithm {
	public static boolean isValid(long number) {
		int sum = 0;
		boolean alternate = false;
		while(number > 0) {
			long digit = number % 10;
			if (alternate) {
				sum += 2 * digit;
				if (digit >= 5) {
					sum -= 9;
				}
			} else {
				sum += digit;
			}
			number = number / 10;
			alternate = !alternate;
		}
		return sum % 10 == 0;
	}

	public static boolean isValid(String number) {
		return isValid(Long.parseLong(number));
	}

	public static void main(String[] args) {
		System.out.println(String.format("234567 is valid: %s", isValid(234567L)));
		System.out.println(String.format("234567 is valid: %s", isValid("234567")));
		System.out.println(String.format("1234567 is valid: %s", isValid(1234567)));
		System.out.println(String.format("1234567 is valid: %s", isValid("1234567")));
	}
	
}
