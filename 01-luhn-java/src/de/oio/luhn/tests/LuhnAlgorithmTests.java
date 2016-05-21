package de.oio.luhn.tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import de.oio.luhn.AbstractTest;
import de.oio.luhn.LuhnAlgorithm;
import de.oio.luhn.LuhnCheck;

public class LuhnAlgorithmTests extends AbstractTest {

	public LuhnAlgorithmTests(String creditCardType, String creditCardNumber) {
		super(creditCardType, creditCardNumber);
	}

	@Test
	public void algorithmWithPreJava8Variant1() {
		assertTrue(String.format("credit card type %s with number %s", creditCardType, creditCardNumber), LuhnAlgorithm.isValid(creditCardNumber));
	}
	
	@Test
	public void algorithmWithPreJava8Variant2() {
		assertTrue(String.format("credit card type %s with number %s", creditCardType, creditCardNumber), LuhnCheck.isValid(Long.parseLong(creditCardNumber)));
	}
	
}
