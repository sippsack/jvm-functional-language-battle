package de.oio.luhn;

public class LuhnCheck {

	public static boolean isValid(long number) {
		int total = sumOfDoubleEvenPlace(number) + sumOfOddPlace(number);
		if (total % 10 == 0) {
			return true;
		} else {
			return false;
		}
	}

	public static int sumOfOddPlace(long number) {
		int result = 0;
		while (number > 0) {
			result += (int) (number % 10);
			number = number / 100;
		}
		return result;
	}

	public static int sumOfDoubleEvenPlace(long number) {
		int result = 0;
		long temp = 0;
		while (number > 0) {
			temp = number % 100;
			result += getDigit((int) (temp / 10) * 2);
			number = number / 100;
		}
		return result;
	}

	public static int getDigit(int number) {
		if (number <= 9) {
			return number;
		} else {
			int firstDigit = number % 10;
			int secondDigit = (int) (number / 10);
			return firstDigit + secondDigit;
		}
	}
}
