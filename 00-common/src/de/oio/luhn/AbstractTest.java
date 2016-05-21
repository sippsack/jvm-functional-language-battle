package de.oio.luhn;

import java.util.Arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(value = Parameterized.class)
public abstract class AbstractTest {

	protected final String creditCardType;
	protected final String creditCardNumber;
	protected final Long creditCardNumberAsLong;

	public AbstractTest(String creditCardType, String creditCardNumber) {
		super();
		this.creditCardType = creditCardType;
		this.creditCardNumber = creditCardNumber;
		this.creditCardNumberAsLong = Long.valueOf(creditCardNumber);
	}

	@Parameters(name = "{index}: credit card {0} with number {1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][] {
				{"American Expres", "378282246310005"},
				{"American Express", "371449635398431"},
				{"American Express Corporate", "378734493671000"},
				{"Australian BankCard", "5610591081018250"},
				{"Diners Club", "30569309025904"},
				{"Diners Club", "38520000023237"},
				{"Discover", "6011111111111117"},
				{"Discover", "6011000990139424"},
				{"JCB", "3530111333300000"},
				{"JCB", "3566002020360505"},
				{"MasterCard", "5555555555554444"},
				{"MasterCard", "5105105105105100"},
				{"Visa", "4111111111111111"},
				{"Visa", "4012888888881881"},
				{"Visa", "4222222222222"},
				{"Dankort (PBS)", "5019717010103742"},
				{"Switch/Solo (Paymentech)", "6331101999990016"}
		});
	}
}
