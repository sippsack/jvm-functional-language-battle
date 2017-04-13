package de.oio.luhn.codegolf;

public class HttpCall {
	public static boolean luhn(String s) {
		int r = 3;
		try {
			r = new java.net.URL("http://cg.k.vu/" + s).openStream().read();
		} finally {
			return r < 2;
		}
	}

	public static void main(String[] args) {
		System.out.println(luhn("234567"));
		System.out.println(luhn("1234567"));
	}
}
