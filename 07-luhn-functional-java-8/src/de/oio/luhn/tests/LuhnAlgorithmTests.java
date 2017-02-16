package de.oio.luhn.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.oio.luhn.AbstractTest;
import de.oio.luhn.functional_java.LuhnAlgorithmJava8FunctionalJava;

public class LuhnAlgorithmTests extends AbstractTest {

	public LuhnAlgorithmTests(String creditCardType, String creditCardNumber) {
		super(creditCardType, creditCardNumber);
	}

	@Test
	public void algorithmWithJava8Functional() {
		assertTrue(String.format("credit card type %s with number %s", creditCardType, creditCardNumber), LuhnAlgorithmJava8FunctionalJava.isValid(creditCardNumberAsLong));
	}
}
