package de.oio.luhn

import static org.junit.Assert.*;

import org.junit.Test
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;;

class LuhnAlgorithmTest extends AbstractTest  {

	public LuhnAlgorithmTest(String creditCardType, String creditCardNumber) {
		super(creditCardType, creditCardNumber);
	}

	@Test
	public void algorithmWithEachAndTemporaryField() {
		assertTrue(String.format("credit card type %s with number %s", creditCardType, creditCardNumber), LuhnAlgorithm.isValid(creditCardNumber));
	}
	
	@Test
	public void algorithmWithInject() {
		assertTrue(String.format("credit card type %s with number %s", creditCardType, creditCardNumber), LuhnAlgorithm.isValid2(creditCardNumber));
	}

}
