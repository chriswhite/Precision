Puma
Precise Unbounded MAthematics

    Puma numbers maintain precision along a series of calculations comprised of various operations including division that may result with infinite or infinitely recurring results

    Puma numbers can represent their value precisely as a string, regardless of any infinities, that may be persisted to a database then later retrieved and used to continue any precise calculations

    Puma numbers support a wide range of operations such as addition and subtraction, multiplication and division, reciprocal and scale, modulus and remainder, exponents and roots, and a range of comparison operations

    Puma numbers incorporate the standard Java rounding mechanisms to obtain a rounded result for reporting or presentation

    Puma is released under the GNU General Public License

Introduction
Problem Domain

Consider an investment fund that initially holds one million dollars and grows at a rate of ten per cent each year. Three corporations have agreed to an equal stake in the investment fund and each corporation has a number of shareholders each of whom receives a proportionate annual dividend resulting from the profits earned by the investment fund.

The formula used to calculate the annual dividend received by a particular shareholder is as follows:

D = ( ( ( (I * 1.1) - I) / 3) / S) * s

Where D is the annual dividend, I is the value of the investment fund, S is the total number of shares allocated by the shareholder's company, and s is the number of shares held by the shareholder.

Assuming that this year is the first year of the investment fund, and assuming that this particular corporation has allocated one thousand shares in total, and assuming that this particular shareholder holds one hundred shares, the dividend is therefore calculated as follows:

D = ( ( ( (1000000 * 1.1) - 1000000) / 3) / 1000) * 100

Java provides a component named BigDecimal that must be used for calculations due to logical problems inherent to primitive types in all languages. Employing BigDecimal to calculate the annual dividend of the shareholder results in the following code:

try {

	BigDecimal dividend = new BigDecimal("1000000.00").multiply(new BigDecimal("1.1")).subtract(new BigDecimal("1000000.00"))
		.divide(new BigDecimal("3")).divide(new BigDecimal("1000")).multiply(new BigDecimal("100"));

} catch (ArithmeticException expected) {

	// prints java.lang.ArithmeticException: Non-terminating decimal expansion; no exact representable decimal result.
	System.out.println(expected);

}

BigDecimal throws an ArithmeticException because the profits of the investment fund must be shared equally between three corporations, resulting with an infinitely recurring floating-point number that must be rounded when the profits are divided between the corporations, therefore a rounding mode and scale must be specified to the divide operation:

BigDecimal dividend = new BigDecimal("1000000.00").multiply(new BigDecimal("1.1")).subtract(new BigDecimal("1000000.00"))
	.divide(new BigDecimal("3"), 2, RoundingMode.HALF_EVEN).divide(new BigDecimal("1000")).multiply(new BigDecimal("100"));

System.out.println(dividend.toPlainString()); // prints 3333.33300

Clearly we cannot pay 3,333.333 dollars because we can only pay whole numbers of dollars and cents, and the result calls for a payment of 3,333 dollars and 33.3 cents, therefore we must reformulate our equation so that the divide operation is called just once at the end of the calculation:

D = ( ( ( (I * 1.1) - I) / 3) / S) * s
D / s = ( ( (I * 1.1) - I) / 3) / S
(D * S) / s = ( (I * 1.1) - I) / 3
(D * S * 3) / s = (I * 1.1) - I
(D * S * 3) / (s * ( (I * 1.1) - I) ) = 1
(S * 3) / (s * ( (I * 1.1) - I) ) = 1 / D
( s * ( (I * 1.1) - I) ) / (S * 3) = D

Where D is the annual dividend, I is the value of the investment fund, S is the total number of shares allocated by the shareholder's company, and s is the number of shares held by the shareholder.

The dividend is therefore calculated as follows:

D = ( 100 * ( (1000000 * 1.1) - 1000000) ) / (1000 * 3)
D = ( 100 * ( (1000000 * 1.1) - 1000000) ) / 3000

Resulting with the following code:

BigDecimal dividend = new BigDecimal("1000000.00").multiply(new BigDecimal("1.1")).subtract(new BigDecimal("1000000.00"))
	.multiply(new BigDecimal("100")).divide(new BigDecimal("3000"), 2, RoundingMode.HALF_EVEN);

System.out.println(dividend.toPlainString()); // prints 3333.33

Therefore the shareholder receives a dividend of 3,333 dollars and 33 cents.

Reformulating the equation was relatively easy in this case but nevertheless requires extra work, results in code that is not easily related to the parent formula, and introduces extra potential for mistakes. Moreover in the case of extremely complex equations, such as the equations for fluid dynamics or superstring theory, reformulating such equations would become exponentially unrealistic.

Enter Puma

Puma does not require any reformulation of equations and maintains exact precision along the series of calculations implied by the formula. Reviewing the formula used to calculate the annual dividend received by a particular shareholder:

D = ( ( ( (I * 1.1) - I) / 3) / S) * s

Where D is the annual dividend, I is the value of the investment fund, S is the total number of shares allocated by the shareholder's company, and s is the number of shares held by the shareholder.

The dividend is therefore calculated as follows:

D = ( ( ( (1000000 * 1.1) - 1000000) / 3) / 1000) * 100

Employing Puma instead of BigDecimal results in the following code:

Puma dividend = new Puma("1000000.00").multiply(new Puma("1.1")).subtract(new Puma("1000000.00")).divide(new Puma("3"))
	.divide(new Puma("1000")).multiply(new Puma("100"));

System.out.println(dividend); // prints 1/0.0003

The result of 1 / 0.0003 is difficult to visualise but is absolutely precise and the various divide operations will never give rise to any exceptions.

In order to obtain a rounded result for reporting or presentation we simply create a Puma 'rounded' decorator and then apply the rounding operation with the appropriate rounding mode and scale as follows:

String rounded = dividend.createRoundedDecorator().toRoundedString(2, RoundingMode.HALF_EVEN);
System.out.println(rounded); // prints 3333.33

Therefore the shareholder receives a dividend of 3,333 dollars and 33 cents.

Advanced Usage
Algebraic Expressions

Puma also supports algebraic expressions so, instead of coding the aforementioned chain of BigDecimal or Puma operations, we can simply create a Puma expression that comprises the entire formula:

Puma dividend = new PumaExpression("( ( ( (1000000 * 1.1) - 1000000) / 3) / 1000) * 100").evaluate();
String rounded = dividend.createRoundedDecorator().toRoundedString(2, RoundingMode.HALF_EVEN);
System.out.println(rounded); // prints 3333.33

Use the templating strategy of your choice to generalise the formula, such as Apache Velocity or Freemarker or the Commons Lang StrSubstitutor or Java regular expressions, or simply use the Java String format operation:

// D = ( ( ( (I * 1.1) - I) / 3) / S) * s
String formula = "( ( ( (%s * 1.1) - %s) / 3) / %s) * %s";

String calculation = String.format(formula, "1000000", "1000000", "1000", "100");

System.out.println(calculation); // prints ( ( ( (1000000 * 1.1) - 1000000) / 3) / 1000) * 100

Puma dividend = new PumaExpression(calculation).evaluate();

String rounded = dividend.createRoundedDecorator().toRoundedString(2, RoundingMode.HALF_EVEN);

System.out.println(rounded); // prints 3333.33

Heavy Calculations

Imagine that the calculation of the share of profits from the investment fund, for each of the three corporations which share an equal stake in the fund, has an execution time measured in seconds rather than nanoseconds. Further imagine that the remaining calculation, to derive the dividend received by a particular shareholder, also requires several seconds to execute on the production system.

If the production system crashes after the calculation of the share of profits, and during the calculation to derive the dividend, then all the work performed in order to calculate the share of profits must be repeated.

Best practice would recommend a piece-meal calculation; first calculating the share of profits, then persisting that result to the application database, then calculating the dividend using either that value from the database, if the system crashed, or the extant result of the share of profits calculation, if the system did not crash.

Using that strategy the calculation of the share of profits would not have to be repeated if the system crashes. However, since the result of that calculation yields an infinitely recurring number, Puma and not BigDecimal must be employed to represent the result as a fraction.

Using Puma to represent a fraction, where both the numerator and denominator of the fraction will always be rational numbers, avoids any need for rounding in order to yield a rational number with a terminating decimal expansion; a finite number of decimal places, which can be persisted to the database:

import com.zavazoo.puma.Puma;

/**
 * Calculates the dividend for a particular shareholder.
 */
public class DividendCalculator {

	/** The result of the share of profits calculation. */
	private Puma share;

	public void calculateDividend() {
		calculateShare();
		Puma dividend = share.divide(new Puma("1000")).multiply(new Puma("100"));
	}

	private void calculateShare() {
		share = getShare();
		if (share == null) {
			share = new Puma("1000000.00").multiply(new Puma("1.1"))
				.subtract(new Puma("1000000.00")).divide(new Puma("3"));
			setShare(share);
		}
	}

	/**
	 * Gets the calculated share from the application database.
	 * @return the share or null if the share does not exist in the database and therefore has not yet been calculated.
	 */
	private Puma getShare() {
		// retrieve the share as a concise string from the database
		// String concise = ShareDao.getShare();
		
		// if the share does not exist in the database then return null
		// if(concise == null) { return null; }
		
		// otherwise return a new puma number created using that concise string
		// return new Puma(concise);

		// return null so that this example class will compile
		return null;
	}

	/**
	 * Sets the calculated share in the application database.
	 * @param share the share.
	 */
	private void setShare(Puma share) {
		// represent the puma number as the most concise fraction possible
		String concise = share.createFractionDecorator().toFractionString();
		
		// set the share as a concise string in the database
		// ShareDao.setShare(concise);
	}
}

© 2010-2013 Chris White. All rights reserved
