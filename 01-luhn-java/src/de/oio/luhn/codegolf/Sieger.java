package de.oio.luhn.codegolf;

public class Sieger {
	public static boolean luhn(String s) {
		int p = 0, i = s.length();
		for (int c : s.getBytes())
			p += (c - 8 << ++i % 2) % 89;
		return p % 10 < 1;
	}
	
	public static void main(String[] args) {
		System.out.println(luhn("234567"));
		System.out.println(luhn("1234567"));
	}
}
